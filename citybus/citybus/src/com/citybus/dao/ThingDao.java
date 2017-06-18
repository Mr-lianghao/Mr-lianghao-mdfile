package com.citybus.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.citybus.domain.News;
import com.citybus.domain.Things;
import com.citybus.util.C3P0Util;

public class ThingDao {
	public int addThing(Things things) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return qr.update("insert into things (thing_name,thing_date,thing_detail,thing_people,thing_peoplePhone,thing_flag,thing_routeNum,state)values( ? , ? , ? , ? ,? , ? , ? , ? )", 
											things.getThing_name(),things.getThing_date(),things.getThing_detail(),things.getThing_people(),things.getThing_peoplePhone(),things.getThing_flag(),things.getThing_routeNum(),"1");
	}

	public List<Things> findAll() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return qr.query("select * from things", new BeanListHandler<Things>(Things.class));
	}

	public int count() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return (Integer) qr.query("select count(*) from things", new ScalarHandler());
	}

	public List<Things> getPageThings(int currentPage, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("exec sp_thingspage ?,?", new BeanListHandler<Things>(Things.class), currentPage,pageSize);

	}

	public List<Things> findByID(String iD) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from things where ID=?", new BeanListHandler<Things>(Things.class), iD);
	}

	public List<Things> getThingsByTitle(String thing_name, int currentPage,
			int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("exec sp_page_search_things ?,?,?", new BeanListHandler<Things>(Things.class), currentPage,pageSize,thing_name);

	}

}
