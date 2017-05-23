package com.newer.model;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private List<T> data = new ArrayList<T>();
	private int pageNo;
	private int pageSize;
	private int total;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	/*
	 * 返回总页数的方法
	 */
	public int getTotalPage() {
		return (this.total + this.pageSize - 1) / this.pageSize;
	}

	public int getFirst() {
		if (this.pageNo==1) {
			return this.pageNo;

		} else {
			return this.pageNo-1;

		}
	}

	/*
	 * 返回下一页页号
	 */
	public int getLast() {
		if (this.pageNo == this.getTotalPage()) {
			return this.getTotalPage();
		} else {
			return this.pageNo + 1;
		}
	}

}
