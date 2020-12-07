package com.bookstore.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.bean.Book;
import com.bookstore.bean.Page;
import com.bookstore.service.BookService;
import com.bookstore.utils.WebUtil;

/**
 * 管理图书
 */
@Controller
@RequestMapping("/bookManage")
public class BookManageController {
	@Autowired
	BookService bookService;

	/**
	 * 去更新图书的页面
	 */
	@RequestMapping("/toUpdateBook.do")
	protected ModelAndView toUpdateBook(HttpServletRequest request, HttpServletResponse response, int id) throws Exception {
		Book book = bookService.selectBookById(id);
		ModelAndView mav = new ModelAndView("manager/book_edit");
		mav.addObject("book", book);
		return mav;
	}

	/**
	 * 添加或者更新图书
	 */
	@RequestMapping("/updateBook.do")
	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String title = null;
		String price = null;
		String author = null;
		String sales = null;
		String stock = null;
		String bookId = null;
		FileItem imgItem = null;
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> fileItems = upload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					switch (name) {
					case "bookId":
						bookId = value;
						break;
					case "book_title":
						title = value;
						break;
					case "book_price":
						price = value;
						break;
					case "book_author":
						author = value;
						break;
					case "book_sales":
						sales = value;
						break;
					case "book_stock":
						stock = value;
						break;
					default:
						break;
					}
				} else {
					imgItem = fileItem;
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		if ("".equals(bookId)) {
			Book book = new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
			Book insertBook = bookService.insertBook(book);
			bookId = String.valueOf(insertBook.getId());
		} else {
			Book book = new Book(Integer.parseInt(bookId), title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
			bookService.updateBook(book);
		}
		if (imgItem != null && "book_imgPath".equals(imgItem.getFieldName()) && !"".equals(imgItem.getName())) {
			String imgPath = "common/img/book/" + bookId + ".jpg";
			InputStream stream = imgItem.getInputStream();
			System.out.println("文件上传项【name=" + imgItem.getFieldName() + "】【文件名=" + imgItem.getName() + "】【文件大小：" + stream.available() + "】");
			String realPath = request.getServletContext().getRealPath("/");
			System.out.println("真实路径：" + realPath);
			FileOutputStream os = new FileOutputStream(realPath + "/" + imgPath);
			InputStream is = imgItem.getInputStream();
			IOUtils.copy(is, os);
			is.close();
			os.close();
			bookService.updateBookImgPath(Integer.parseInt(bookId), imgPath);
		}
		response.sendRedirect(request.getContextPath() + "/bookManage/getManagePageBook.do");
	}

	/**
	 * 删除图书
	 */
	@RequestMapping("/deleteBook.do")
	protected void deleteBook(HttpServletRequest request, HttpServletResponse response, int id) throws Exception {
		bookService.deleteBook(id);
		String referer = request.getHeader("Referer");
		response.sendRedirect(referer);
	};

	/**
	 * 获取所有图书
	 */
	@RequestMapping("/getBookList.do")
	protected ModelAndView getBookList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Book> bookList = bookService.selectBookList();
		ModelAndView mav = new ModelAndView("manager/book_list");
		mav.addObject("books", bookList);
		return mav;
	}

	/**
	 * 获取分页图书
	 */
	@RequestMapping("/getManagePageBook.do")
	protected ModelAndView getManagePageBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Page<Book> pageBook = bookService.getPageBook(1, null, null);
		pageBook.setPath(WebUtil.getPagePath(request));
		ModelAndView mav = new ModelAndView("manager/book_list");
		mav.addObject("page", pageBook);
		return mav;
	}
}
