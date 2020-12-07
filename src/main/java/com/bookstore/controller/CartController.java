package com.bookstore.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.bean.Book;
import com.bookstore.bean.Cart;
import com.bookstore.bean.CartItem;
import com.bookstore.service.BookService;
import com.bookstore.utils.JsonUtil;
import com.bookstore.utils.WebUtil;

/**
 * 处理购物车操作
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	BookService bookService;

	/**
	 * 添加购物项
	 */
	@RequestMapping("/insertCartItem.do")
	protected void insertCartItem(HttpServletRequest request, HttpServletResponse response, int id) throws Exception {
		Book book = bookService.selectBookById(id);
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addCartItem(book);
		cart.setLastBook(book);
		// 封装数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", cart.getTotalCount());
		map.put("title", book.getTitle());
		// 转为JSON
        WebUtil.response(response, JsonUtil.getResponse(map));
	}

	/**
	 * 删除购物项
	 */
	@RequestMapping("/deleteCartItem.do")
	protected void deleteCartItem(HttpServletRequest request, HttpServletResponse response, int id) throws Exception {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.deleteCartItem(id);
		response.sendRedirect(request.getHeader("referer"));
	}

	/**
	 * 清空购物项
	 */
	@RequestMapping("/clearCartItem.do")
	protected void clearCartItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.clearCartItem();
		response.sendRedirect(request.getHeader("referer"));
	}

	/**
	 * 修改购物项
	 */
	@RequestMapping("/updateCartItem.do")
	protected void updateCartItem(HttpServletRequest request, HttpServletResponse response, int id, int count) throws Exception {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.updateCartItem(id, count);
		// 封装数据
		Map<String, Object> map = new HashMap<String, Object>();
		CartItem cartItem = cart.getCartItem(id);
		double price = cartItem.getTotalPrice();
		map.put("price", price);
		map.put("totalCount", cart.getTotalCount());
		map.put("totalPrice", cart.getTotalPrice());
		// 转为JSON
        WebUtil.response(response, JsonUtil.getResponse(map));
	}
}
