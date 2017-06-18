package com.citybus.domain;

import java.util.List;

public class PageBean_Things {

	private int currentPage;
	private int pageSize;
	private int count;
	private int totalPage;
	private List<Things> things;
	private String thing_name;
	
	
	public String getThing_name() {
		return thing_name;
	}
	public void setThing_name(String thing_name) {
		this.thing_name = thing_name;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Things> getThings() {
		return things;
	}
	public void setThings(List<Things> things) {
		this.things = things;
	}
	
}
