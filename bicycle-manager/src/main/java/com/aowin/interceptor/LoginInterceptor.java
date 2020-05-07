package com.aowin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.aowin.dao.SyuserMapper;

public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private SyuserMapper syuserMapper;

	/**
	 * 预处理程序 调用controller方法之前
	 * 返回false 不继续执行
	 * 返回true 继续执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
	        HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("syuser");
		if (user == null) {
			//未登录
			response.sendRedirect(request.getContextPath() + "/index.html");
			//			response.setContentType("text/html;charset=utf-8");
			//			response.getWriter()
			//			        .println("<script language=\"javascript\">alert(\"没有权限!\");"
			//			                + "window.location.href=\"../index.html\";</script>");
			//			response.getWriter().flush();
			return false;
		}
		return true;
	}

}
