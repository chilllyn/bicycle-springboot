package com.aowin.dao;

import com.aowin.model.Syuser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 83998
 */
@Mapper
public interface SyuserMapper {

	/**
	 * 通过roleId获取有权限的url路径
	 * @param roleId
	 * @return
	 */
	List<String> getUrl(Integer roleId);

	/**
	 * 通过手机号获取用户
	 * @param mobilePhone
	 * @return
	 */
	Syuser getSyuserByMobilePhone(String mobilePhone);

	/**
	 * 登录
	 * @param syuser
	 * @return
	 */
	Syuser login(Syuser syuser);

}
