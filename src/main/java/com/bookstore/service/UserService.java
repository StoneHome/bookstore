package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bean.User;
import com.bookstore.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	public User selectUser(User u) {
		User user = userMapper.selectUser(u);
		return user;
	}

	public boolean checkUsername(String username) {
		return userMapper.selectUserByUsername(username) == null;
	}

	public void insertUser(User user) {
		userMapper.insertUser(user);
	}
}
