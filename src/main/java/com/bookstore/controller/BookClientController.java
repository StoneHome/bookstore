package com.bookstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;
import com.bookstore.service.BookService;
import com.bookstore.utils.WebUtil;

/**
 * 查看图书
 */
@Controller
@RequestMapping("/bookClient")
public class BookClientController {
	@Autowired
	BookService bookService;

	/**
	 * 获取分页图书
	 */
	@RequestMapping("/getClientPageBook.do")
	protected ModelAndView getClientPageBook(HttpServletRequest request, HttpServletResponse response, Integer pageNo, Double minPrice, Double maxPrice) throws Exception {
		pageNo = pageNo == null ? 1 : pageNo;
		Page<Book> pageBook = bookService.getPageBook(pageNo, minPrice, maxPrice);
		pageBook.setPath(WebUtil.getPagePath(request));
		ModelAndView mav = new ModelAndView("book/book_list");
		mav.addObject("page", pageBook);
		return mav;
	}
}
