package com.aowin.service.impl;

import com.aowin.dao.SyuserMapper;
import com.aowin.model.Syuser;
import com.aowin.service.SyuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 83998
 */
@Service
public class SyuserServiceImpl implements SyuserService {

	@Resource
	private SyuserMapper syuserMapper;

	@Override
	public Syuser login(Syuser syuser) {
		return syuserMapper.login(syuser);
	}

	@Override
	public Syuser getSyuserByMobilePhone(String mobilePhone) {
		return syuserMapper.getSyuserByMobilePhone(mobilePhone);
	}

	@Override
	public boolean isPermission(String path, Integer roleId) {
		List<String> url = syuserMapper.getUrl(roleId);
		for (String str : url) {
			if (path.contains(str)) {
				return true;
			}
		}
		return false;
	}
}
