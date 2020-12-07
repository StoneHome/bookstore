package com.bookstore.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.bean.User;

public class WebUtil {

	/**
	 * 获取请求路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getPagePath(HttpServletRequest request) {
		// 获取请求地址
		String requestURI = request.getRequestURI();
		// 获取请求字符串
		String queryString = request.getQueryString();
		// 判断queryString是否为空
		if (queryString == null) {
			return requestURI;
		}
		// 判断queryString中是否含有&pageNo
		if (queryString.contains("&pageNo")) {
			// 如果含有&pageNo就将它截取
			queryString = queryString.substring(0, queryString.indexOf("&pageNo"));
		}
		// 拼接请求地址和请求字符串
		return requestURI + "?" + queryString;
	}

	/**
	 * 创建订单号
	 * 
	 * @param user
	 * @return
	 */
	public static String createOrderId(int uid) {
		long millis = System.currentTimeMillis();
		String oid = millis + "" + uid;
		return oid;
	}

	/**
	 * 返回当前系统用户
	 * 
	 * @return
	 */
	public static User getCurrentUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		return user;
	}

    public static void response(HttpServletResponse response, String result) {
        PrintWriter pw = null;
        try {
            response.setContentType("application/json;charset=UTF-8");
            pw = response.getWriter();
            pw.print(result);
            pw.flush();
            response.flushBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
