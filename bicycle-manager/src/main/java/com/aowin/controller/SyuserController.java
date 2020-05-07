package com.aowin.controller;

import javax.jms.Queue;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aowin.model.Syuser;
import com.aowin.service.SyuserService;
import com.aowin.service.CodeService;

@RestController
public class SyuserController {
	@Autowired
	private SyuserService syuserServiceImpl;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private CodeService codeServiceImpl;
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
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
		if (!mobilePhone.matches("^[1]([3-9])[0-9]{9}$")) {
			return "error1";
		}
		if (syuserServiceImpl.getSyuserByMobilePhone(mobilePhone) == null) {
			return "error2";
		}
		jmsMessagingTemplate.convertAndSend(queue,mobilePhone);
//		jmsTemplate.convertAndSend(mobilePhone); // 将手机号码发送至JMS中
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
		if (!mobilePhone.matches("^[1]([3-9])[0-9]{9}$")) {
			return null;
		}
		if (!verificationCode.matches("^[0-9]{4}$")) {
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
