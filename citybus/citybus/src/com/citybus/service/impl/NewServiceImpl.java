package com.citybus.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.citybus.dao.NewsDaoImpl;
import com.citybus.domain.News;
import com.citybus.domain.PageBean_News;

public class NewServiceImpl {
	NewsDaoImpl ndi = new NewsDaoImpl();
	
	public List<News> getTopNew() {
		
		try {
			List news = ndi.getTopNew();
			return news;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public News findNewsById(String id) {
		// TODO Auto-generated method stub
		try {
			News news = ndi.findNewsById(id);
			return news;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public PageBean_News findAllNews(int currentPage,int pageSize) {
		
		try {
			PageBean_News pbn = new PageBean_News();
			//取出count
			int count = ndi.count();
			int totalPage = (int) Math.ceil(count*1.0/pageSize);
			List<News> topNew = ndi.getPageNew(currentPage,pageSize);
			
			pbn.setCount(count);
			pbn.setCurrentPage(currentPage);
			pbn.setNews(topNew);
			pbn.setPageSize(pageSize);
			pbn.setTotalPage(totalPage);
			return pbn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	}

	public PageBean_News finNewsByTitle(String newstitle, int currentPage,
			int pageSize) {
		try {
			PageBean_News pbn = new PageBean_News();
			//取出count
			int count = ndi.count_search(newstitle);
			int totalPage = (int) Math.ceil(count*1.0/pageSize);
			List<News> topNew = ndi.finNewsByTitle(newstitle,currentPage,pageSize);
			
			pbn.setCount(count);
			pbn.setCurrentPage(currentPage);
			pbn.setNews(topNew);
			pbn.setPageSize(pageSize);
			pbn.setTotalPage(totalPage);
			return pbn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	}

	public int updateNew(News news) {
		try {
			int i = ndi.updateNew(news);
			return i;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int insertNews(News news) {
		try {
			int i = ndi.insertNews(news);
			return i;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public int delNewsById(String id) {
		try {
			int i = ndi.delNewsById(id);
			return i;
		} catch (Exception e) {
		}
		return 0;
	}
	

}
