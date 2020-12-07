package com.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.bean.Order;
import com.bookstore.service.OrderService;

@Controller
@RequestMapping("/orderManage")
public class OrderManageController {
	@Autowired
	OrderService orderService;

	/**
	 * 显示所有订单
	 */
	@RequestMapping("/getManageOrderList.do")
	protected ModelAndView getManageOrderList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Order> orders = orderService.getOrderList();
		ModelAndView mav = new ModelAndView("manager/order_list");
		mav.addObject("orders", orders);
		return mav;
	}

	/**
	 * 发货
	 */
	@RequestMapping("/sendOrder.do")
	protected void sendOrder(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
		orderService.sendOrder(id);
		response.sendRedirect(request.getContextPath() + "/orderManage/getManageOrderList.do");
	}
}
