package com.bookstore.bean;

/**
 * 订单项模型
 */
public class OrderItem {

	private Integer id;
	private String oid;// 订单项关联的订单
	private String title;
	private String author;
	private double price;
	private int count;
	private double totalPrice;

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", oid=" + oid + ", title=" + title
				+ ", author=" + author + ", price=" + price + ", count="
				+ count + ", totalPrice=" + totalPrice + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
