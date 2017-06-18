package com.citybus.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.citybus.dao.ThingDao;
import com.citybus.domain.News;
import com.citybus.domain.PageBean_Things;
import com.citybus.domain.Things;
public class ThingServiceImpl {
	private ThingDao thingDao = new ThingDao();
	public void insert(Things things){
		
		try {
			thingDao.addThing(things);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public PageBean_Things findAllNews(int currentPage, int pageSize) {
		try {
			PageBean_Things pbt = new PageBean_Things();
			int  count = thingDao.count();
			
			int totalPage = (int) Math.ceil(count*1.0/pageSize);
			List<Things> things = thingDao.getPageThings(currentPage,pageSize);
			pbt.setCount(count);
			pbt.setCurrentPage(currentPage);
			pbt.setThings(things);
			pbt.setPageSize(pageSize);
			pbt.setTotalPage(totalPage);
			return pbt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Things> findByID(String ID) {
		try {
			return thingDao.findByID(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public PageBean_Things finNewsByTitle(String thing_name, int currentPage,
			int pageSize) {
		try {
			PageBean_Things pbt = new PageBean_Things();
			int  count = thingDao.count();
			
			int totalPage = (int) Math.ceil(count*1.0/pageSize);
			List<Things> things = thingDao.getThingsByTitle(thing_name,currentPage,pageSize);
			pbt.setCount(count);
			pbt.setCurrentPage(currentPage);
			pbt.setThings(things);
			pbt.setPageSize(pageSize);
			pbt.setTotalPage(totalPage);
			return pbt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
