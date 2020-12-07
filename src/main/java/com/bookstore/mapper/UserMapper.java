package com.bookstore.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.bookstore.bean.User;

public interface UserMapper {

	@Select("select * from bs_user where username = #{username} and password = #{password}")
	public User selectUser(User user);

	@Select("select * from bs_user where username = #{username}")
	public User selectUserByUsername(String username);

	@Insert("insert into bs_user(username, password, email) values(#{username}, #{password}, #{email})")
	public void insertUser(User user);
}
