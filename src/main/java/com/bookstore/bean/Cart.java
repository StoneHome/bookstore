package com.bookstore.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 购物车模型
 */
public class Cart {

	private LinkedHashMap<Integer, CartItem> map = new LinkedHashMap<>();
	
	private Book lastBook;

	public Cart() {
		super();
	}

	public Book getLastBook() {
		return lastBook;
	}

	public void setLastBook(Book lastBook) {
		this.lastBook = lastBook;
	}

	/**
	 * 计算总数量
	 * 
	 * @return
	 */
	public int getTotalCount() {
		List<CartItem> cartItems = getCartItemList();
		int count = 0;
		for (CartItem cartItem : cartItems) {
			count += cartItem.getCount();
		}
		return count;
	}

	/**
	 * 计算总金额
	 * 
	 * @return
	 */
	public double getTotalPrice() {
		List<CartItem> cartItems = getCartItemList();
		BigDecimal totalPrice = new BigDecimal("0.0");
		for (CartItem cartItem : cartItems) {
			totalPrice = totalPrice.add(new BigDecimal(String.valueOf(cartItem.getTotalPrice())));
		}
		return totalPrice.doubleValue();
	}
	
	/**
	 * 获取所有购物项
	 * 
	 * @return
	 */
	public List<CartItem> getCartItemList() {
		Collection<CartItem> values = map.values();
		ArrayList<CartItem> cartItems = new ArrayList<>(values);
		return cartItems;
	}
	
	/**
	 * 获取购物项
	 * 
	 * @return
	 */
	public CartItem getCartItem(int id) {
		CartItem cartItem = map.get(id);
		return cartItem;
	}

	/**
	 * 添加购物项
	 * 
	 * @param book
	 */
	public void addCartItem(Book book) {
		int count = 1;
		CartItem cartItem = map.get(book.getId());
		if (cartItem != null) {
			count = cartItem.getCount() + 1;
			map.remove(book.getId());
		}
		map.put(book.getId(), new CartItem(book, count));
	}

	/**
	 * 删除购物项
	 * 
	 * @param bookId
	 */
	public void deleteCartItem(int id) {
		map.remove(id);
	}

	/**
	 * 修改购物项
	 * 
	 * @param book
	 * @param count
	 */
	public void updateCartItem(int id, int count) {
		CartItem cartItem = map.get(id);
		cartItem.setCount(count);
	}

	/**
	 * 清空购物项
	 */
	public void clearCartItem() {
		map.clear();
	}
}
