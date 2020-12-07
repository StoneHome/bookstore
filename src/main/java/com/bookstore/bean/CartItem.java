package com.bookstore.bean;

import java.math.BigDecimal;

/**
 * 购物项模型
 */
public class CartItem {

	private Book book;

	private int count;

	public CartItem() {
		super();
	}

	public CartItem(Book book, int count) {
		super();
		this.book = book;
		this.count = count;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * 获取总价的时候进行计算
	 * 
	 * @return
	 */
	public double getTotalPrice() {
		Double price = getBook().getPrice();
		BigDecimal totalPrice = new BigDecimal(price.toString()).multiply(new BigDecimal(count));
		return totalPrice.doubleValue();
	}
}
