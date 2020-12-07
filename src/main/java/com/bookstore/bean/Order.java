package com.bookstore.bean;

import java.util.Date;

/**
 * 订单模型
 */
public class Order {

	private String id;
	private Integer uid;// 订单关联的用户
	private double cost;
	private int status = 0;// 订单状态：0-未发货；1-已发货；2-交易完成（用户确认收货了）
	private Date createTime;

	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", cost=" + cost
				+ ", status=" + status + ", createTime=" + createTime + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
