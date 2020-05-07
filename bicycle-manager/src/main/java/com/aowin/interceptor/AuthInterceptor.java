package com.aowin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.aowin.model.Syuser;
import com.aowin.service.SyuserService;

public class AuthInterceptor implements HandlerInterceptor {

	@Autowired
	private SyuserService syuserServiceImpl;

	/**
	 * 预处理程序 调用controller方法之前
	 * 返回false 不继续执行
	 * 返回true 继续执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
	        HttpServletResponse response, Object handler) throws Exception {
		Syuser user = (Syuser) request.getSession().getAttribute("syuser");
		String path = request.getServletPath();
		boolean flag = syuserServiceImpl.isPermission(path, user.getRoleId());
		if (!flag) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println(
			        "<script language=\"javascript\">alert(\"没有访问权限!\");"
			                + "window.location.href=\"../main/index.html\";</script>");
			response.getWriter().flush();
			response.getWriter().close();
			return false;
		}
		return true;
	}
}
