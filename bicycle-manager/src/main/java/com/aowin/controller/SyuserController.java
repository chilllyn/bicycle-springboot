package com.aowin.controller;

import com.aowin.constants.SysuserConst;
import com.aowin.model.Syuser;
import com.aowin.service.CodeService;
import com.aowin.service.SyuserService;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.servlet.http.HttpSession;

/**
 * @author 83998
 */
@RestController
public class SyuserController {
	@Resource
	private SyuserService syuserServiceImpl;
	@Resource
	private CodeService codeServiceImpl;
	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Resource
	private Queue queue;

	/**
	 * 登出
	 * @param syuser
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public void logout(Syuser syuser, HttpSession session) {
		session.removeAttribute("syuser");
	}

	/**
	 * 获取验证码
	 * @param syuser
	 * @return
	 */
	@RequestMapping("/getCode")
	public String getCode(Syuser syuser) {
		String mobilePhone = syuser.getMobilePhone();
		if (!mobilePhone.matches(SysuserConst.PHONE_PATTERN)) {
			return "error1";
		}
		if (syuserServiceImpl.getSyuserByMobilePhone(mobilePhone) == null) {
			return "error2";
		}
		jmsMessagingTemplate.convertAndSend(queue,mobilePhone);
		return "ok";
	}

	/**
	 * 验证码登录
	 * @param syuser
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginByVerificationCode")
	public Syuser loginByVerificationCode(Syuser syuser, HttpSession session) {
		String mobilePhone = syuser.getMobilePhone();
		String verificationCode = syuser.getVerificationCode();
		if (!mobilePhone.matches(SysuserConst.PHONE_PATTERN)) {
			return null;
		}
		if (!verificationCode.matches(SysuserConst.VERIFICATION_CODE4)) {
			return null;
		}

		Syuser user = codeServiceImpl.loginByVerificationCode(mobilePhone, verificationCode);
		if (user != null) {
			session.setAttribute("syuser", user);
		}
		return user;
	}

	/**
	 * 用户名密码登录
	 * @param syuser
	 * @param br
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public Syuser login(@Validated Syuser syuser, BindingResult br, HttpSession session) {
		//如果验证不合法 直接返回
		if (br.hasErrors()) {
			return null;
		}

		Syuser user = syuserServiceImpl.login(syuser);
		if (user != null) {
			session.setAttribute("syuser", user);
		}
		return user;
	}

}
