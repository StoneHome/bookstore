package com.bookstore.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestDB {
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void test() {
		try {
//			System.out.println(dataSource.getConnection());
			System.out.println(System.currentTimeMillis());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
