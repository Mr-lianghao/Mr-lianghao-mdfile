package com.citybus.domain;

import java.util.List;

public class PageBean_GuestAndReplay {

	private int currentPage;
	private int count;
	private int pageSize;
	private int totalPage;
	private List<GuestAndReplay> list;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<GuestAndReplay> getList() {
		return list;
	}
	public void setList(List<GuestAndReplay> list) {
		this.list = list;
	}
	
	
}
