package com.bookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.bean.User;
import com.bookstore.service.UserService;
import com.bookstore.utils.JsonUtil;
import com.bookstore.utils.WebUtil;
import com.google.code.kaptcha.Constants;

/**
 * 处理用户登录注册
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/login.do")
	protected ModelAndView login(HttpServletRequest request, HttpServletResponse response, String username, String password) throws Exception {
		User user = new User(null, username, password, null);
		User loginUser = userService.selectUser(user);
		if (loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			ModelAndView mav = new ModelAndView("user/login_success");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("user/login");
			mav.addObject("message", "用户名或密码不正确！");
			return mav;
		}
	}

	@RequestMapping("/regist.do")
	protected ModelAndView regist(HttpServletRequest request, HttpServletResponse response, String username, String password, String email, String code) throws Exception {
		HttpSession session = request.getSession();
		String kaptcha = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (kaptcha == null || !kaptcha.equals(code)) {
			ModelAndView mav = new ModelAndView("user/regist");
			mav.addObject("message", "验证码错误！");
			return mav;
		}
		boolean check = userService.checkUsername(username);
		if (check) {
			User user = new User(null, username, password, email);
			userService.insertUser(user);
			ModelAndView mav = new ModelAndView("user/regist_success");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("user/regist");
			mav.addObject("message", "用户名已存在！");
			return mav;
		}
	}

	@RequestMapping("/logout.do")
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	/**
	 * 检查用户名
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/checkUsername.do")
	protected void checkUsername(HttpServletRequest request, HttpServletResponse response, String username) throws Exception {
		boolean result = userService.checkUsername(username);
		if (result) {
	        WebUtil.response(response, JsonUtil.getResponse(0));
		} else {
	        WebUtil.response(response, JsonUtil.getResponse(1));
		}
	}
}
