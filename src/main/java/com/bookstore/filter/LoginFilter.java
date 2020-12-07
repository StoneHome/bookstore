package com.bookstore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.User;
import com.bookstore.utils.WebUtil;

/**
 * 登录过滤器
 */
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		User user = WebUtil.getCurrentUser(req);
		if (user == null) {
			request.setAttribute("message", "此操作需要登陆，请先登陆！");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
	}
}
