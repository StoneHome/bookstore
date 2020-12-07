package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;
import com.bookstore.mapper.BookMapper;

@Service
public class BookService {
	@Autowired
	BookMapper bookMapper;

	public Book selectBookById(int id) {
		return bookMapper.selectBookById(id);
	}

	public List<Book> selectBookList() {
		return bookMapper.selectBookList();
	}

	public Page<Book> getPageBook(int pageNo, Double minPrice, Double maxPrice) {
		Page<Book> page = new Page<Book>();
		page.setPageNo(pageNo);
		long count = bookMapper.getPageBookCount(minPrice, maxPrice);
		page.setTotalRecord((int) count);
		List<Book> beanList = bookMapper.getPageBookList(minPrice, maxPrice, (page.getPageNo() - 1) * Page.PAGE_SIZE, Page.PAGE_SIZE);
		page.setList(beanList);
		return page;
	}

	public Book insertBook(Book book) {
		return bookMapper.insertBook(book);
	}

	public void deleteBook(int id) {
		bookMapper.deleteBook(id);
	}

	public void updateBook(Book book) {
		bookMapper.updateBook(book);
	}

	public void updateBookImgPath(int id, String imgPath) {
		bookMapper.updateBookImgPath(id, imgPath);
	}
}
