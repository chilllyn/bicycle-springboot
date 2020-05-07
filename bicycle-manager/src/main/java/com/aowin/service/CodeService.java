package com.aowin.service;

import com.aowin.model.Syuser;

public interface CodeService {

	/**
	 * 验证码登录
	 * @param mobilePhone
	 * @param verificationCode
	 * @return
	 */
	Syuser loginByVerificationCode(String mobilePhone, String verificationCode);

}
