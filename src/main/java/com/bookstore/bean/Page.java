package com.bookstore.bean;

import java.util.List;

public class Page<T> {

	public static final int PAGE_SIZE = 4; // 每页显示多少条记录

	private List<T> list; // 从数据库中查询的集合
	private int pageNo; // 当前页
	private int totalRecord; // 总记录数

	private String path;// 获取请求地址

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageNo() {
		if (pageNo < 1) {
			return 1;
		} else if (pageNo > getTotalPageNo()) {
			return getTotalPageNo();
		} else {
			return pageNo;
		}
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 总页数通过总记录数和每页显示的条数计算得到
	 * 
	 * @return
	 */
	public int getTotalPageNo() {
		if (totalRecord % PAGE_SIZE == 0) {
			return totalRecord / PAGE_SIZE;
		} else {
			return totalRecord / PAGE_SIZE + 1;
		}
	}

	public static int getPageSize() {
		return PAGE_SIZE;
	}

	/**
	 * 判断是否有上一页
	 * 
	 * @return
	 */
	public boolean hasPrev() {
		return pageNo > 1;
	}

	/**
	 * 获取上一页
	 * 
	 * @return
	 */
	public int getPrev() {
		return hasPrev() ? getPageNo() - 1 : 1;
	}

	/**
	 * 判断是否有下一页
	 * 
	 * @return
	 */
	public boolean hasNext() {
		return pageNo < getTotalPageNo();
	}

	/**
	 * 获取下一页
	 * 
	 * @return
	 */
	public int getNext() {
		return hasNext() ? getPageNo() + 1 : getTotalPageNo();
	}
}
