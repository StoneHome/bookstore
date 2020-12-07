package com.bookstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bookstore.bean.Order;
import com.bookstore.bean.OrderItem;

public interface OrderMapper {

	@Select("select * from bs_order")
	List<Order> getOrderList();

	@Select("select * from bs_order where uid = #{uid}")
	List<Order> getOrderListByUid(int uid);

	@Insert("insert into bs_order(id, uid, cost, status, createTime) values(#{id}, #{uid}, #{cost}, #{status}, #{createTime})")
	void saveOrder(Order order);

	@Update("update bs_order set status = #{status} where id = #{id}")
	void updateOrderStatus(Order order);

	@Insert("insert into bs_order_item(oid, title, author, price, count, totalPrice) values(#{oid}, #{title}, #{author}, #{price}, #{count}, #{totalPrice})")
	void saveOrderItem(OrderItem orderItem);

	@Select("select * from bs_order_item where oid = #{oid}")
	List<OrderItem> getOrderItemListByOid(String oid);
}
