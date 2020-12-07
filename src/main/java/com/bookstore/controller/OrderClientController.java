package com.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.bean.Cart;
import com.bookstore.bean.Order;
import com.bookstore.bean.OrderItem;
import com.bookstore.bean.User;
import com.bookstore.service.OrderService;

@Controller
@RequestMapping("/orderClient")
public class OrderClientController {
	@Autowired
	OrderService orderService;

	/**
	 * 显示所有订单
	 */
	@RequestMapping("/getClientOrderList.do")
	protected ModelAndView getClientOrderList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		List<Order> orders = orderService.getOrderListByUid(user.getId());
		ModelAndView mav = new ModelAndView("order/order");
		mav.addObject("orders", orders);
		return mav;
	}

	/**
	 * 结账
	 */
	@RequestMapping("/checkoutOrder.do")
	protected ModelAndView checkoutOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 使用过滤器判断是否登录
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		Cart cart = (Cart) session.getAttribute("cart");
		String id = orderService.checkoutOrder(cart, user.getId());
		ModelAndView mav = new ModelAndView("cart/checkout");
		mav.addObject("id", id);
		return mav;
	}

	/**
	 * 确认收货
	 */
	@RequestMapping("/receivedOrder.do")
	protected void receivedOrder(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
		orderService.receivedOrder(id);
		response.sendRedirect(request.getContextPath() + "/orderClient/getClientOrderList.do");
	}

	/**
	 * 显示订单详情
	 */
	@RequestMapping("/getClientOrder.do")
	protected ModelAndView getClientOrder(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
		List<OrderItem> orderItems = orderService.getOrderItemListByOid(id);
		ModelAndView mav = new ModelAndView("order/order_info");
		mav.addObject("orderItems", orderItems);
		return mav;
	}
}
