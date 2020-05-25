package com.aowin.interceptor;

import com.aowin.dao.SyuserMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 83998
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Resource
	private SyuserMapper syuserMapper;

	/**
	 * @Author Chill_Lyn
	 * @Description 登录过滤
	 * @Date 2020/5/25 20:26
	 * @Param [request, response, handler]
	 * @return boolean
	 **/
	@Override
	public boolean preHandle(HttpServletRequest request,
	        HttpServletResponse response, Object handler) throws Exception {
		Object user = request.getSession().getAttribute("syuser");
		if (user == null) {
			//未登录
			response.sendRedirect(request.getContextPath() + "/index.html");
			return false;
		}
		return true;
	}

}
