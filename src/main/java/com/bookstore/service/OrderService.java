package com.bookstore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bean.Book;
import com.bookstore.bean.Cart;
import com.bookstore.bean.CartItem;
import com.bookstore.bean.Order;
import com.bookstore.bean.OrderItem;
import com.bookstore.mapper.BookMapper;
import com.bookstore.mapper.OrderMapper;
import com.bookstore.utils.WebUtil;

@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private BookMapper bookMapper;

	public String checkoutOrder(Cart cart, int uid) {
		Order order = new Order();
		String id = WebUtil.createOrderId(uid);
		order.setId(id);
		order.setUid(uid);
		order.setCost(cart.getTotalPrice());
		order.setStatus(0);
		order.setCreateTime(new Date());
		orderMapper.saveOrder(order);

		List<CartItem> cartItems = cart.getCartItemList();
		for (CartItem cartItem : cartItems) {
			// 获取图书
			Book book = cartItem.getBook();
			// 创建订单项
			OrderItem orderItem = new OrderItem();
			orderItem.setOid(id);
			orderItem.setTitle(book.getTitle());
			orderItem.setAuthor(book.getAuthor());
			orderItem.setPrice(book.getPrice());
			orderItem.setCount(cartItem.getCount());
			orderItem.setTotalPrice(cartItem.getTotalPrice());
			// 放到订单项集合
			orderMapper.saveOrderItem(orderItem);
			// 更新图书
			book.setSales(book.getSales() + cartItem.getCount());
			book.setStock(book.getStock() - cartItem.getCount());
			bookMapper.updateBook(book);
		}
		// 清空购物车
		cart.clearCartItem();
		return id;
	}

	public List<Order> getOrderList() {
		return orderMapper.getOrderList();
	}

	public List<Order> getOrderListByUid(int uid) {
		return orderMapper.getOrderListByUid(uid);
	}

	public void sendOrder(String id) {
		Order order = new Order();
		order.setId(id);
		order.setStatus(1);
		orderMapper.updateOrderStatus(order);
	}

	public void receivedOrder(String id) {
		Order order = new Order();
		order.setId(id);
		order.setStatus(2);
		orderMapper.updateOrderStatus(order);
	}

	public List<OrderItem> getOrderItemListByOid(String oid) {
		return orderMapper.getOrderItemListByOid(oid);
	}
}
