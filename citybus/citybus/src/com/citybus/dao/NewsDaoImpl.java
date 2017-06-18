package com.citybus.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.citybus.domain.Line;
import com.citybus.domain.News;
import com.citybus.util.C3P0Util;

public class NewsDaoImpl {

	public List getTopNew() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select top 5 * from news order by newstime ", new BeanListHandler<News>(News.class));

	}

	public News findNewsById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (News) qr.query("select * from news where id=? ", new BeanHandler<News>(News.class),id);
	}

	public List getPageNew(int currentPage, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		//System.out.println("currentPage="+currentPage);
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("exec sp_newspage ?,?", new BeanListHandler<News>(News.class), currentPage,pageSize);
	}

	public int count() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (Integer) qr.query("select count(*) from news", new ScalarHandler());
		
	}

	public int count_search(String title) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (Integer) qr.query("select count(*) from news where newstitle like ?", new ScalarHandler(),'%'+title+'%');
	}

	public List<News> finNewsByTitle(String newstitle, int currentPage,
			int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("exec sp_page_search ?,?,?", new BeanListHandler<News>(News.class), currentPage,pageSize,newstitle);
	}

	public int updateNew(News news) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.update("update news set newstitle=? , publisher=? , newstime=? , newscontent=? where id=? ",  news.getNewstitle(),news.getPublisher(),news.getNewstime(),news.getNewscontent(),news.getId());

	}

	public int insertNews(News news) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.update("insert into news (newstitle,publisher,newstime,newscontent)values(?,?,?,?)", news.getNewstitle(),news.getPublisher(),news.getNewstime(),news.getNewscontent());
	}

	public int delNewsById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.update("delete from news where id=?", id);
	}

}
