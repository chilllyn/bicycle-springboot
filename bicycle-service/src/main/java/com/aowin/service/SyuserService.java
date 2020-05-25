package com.aowin.service;

import com.aowin.model.Syuser;

/**
 * @author 83998
 */
public interface SyuserService {

	/**
	 * 判断是否有访问权限
	 * @param path
	 * @param roleId
	 * @return
	 */
	boolean isPermission(String path, Integer roleId);

	/**
	 * 通过手机号获取用户
	 * @param mobilePhone
	 * @return
	 */
	Syuser getSyuserByMobilePhone(String mobilePhone);

	/**
	 * 验证码登录
	 * @param mobilePhone
	 * @param verificationCode
	 * @return
	 */
	//	Syuser loginByVerificationCode(String mobilePhone, String verificationCode);

	/**
	 * 用户名密码登录
	 * @param syuser
	 * @return
	 */
	Syuser login(Syuser syuser);

}
