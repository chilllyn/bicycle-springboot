package com.aowin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.aowin.dao.SyuserMapper;
import com.aowin.model.Syuser;
import com.aowin.service.CodeService;

@Service
public class CodeServiceImpl implements CodeService {

	@Autowired
	private SyuserMapper syuserMapper;
	@Autowired
	private StringRedisTemplate stringRedisTemlate;

	@Override
	public Syuser loginByVerificationCode(String mobilePhone, String verificationCode) {
		String code = stringRedisTemlate.opsForValue().get(mobilePhone);
		if (!code.equals(verificationCode)) {
			return null;
		}
		return syuserMapper.getSyuserByMobilePhone(mobilePhone);
	}
}
