package com.citybus.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.citybus.domain.Station;
import com.citybus.util.C3P0Util;
import com.citybus.util.ManagerThreadLocal;

public class StationDaoImpl {

	public List<Station> findAllStation() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from station", new BeanListHandler<Station>(Station.class));
		
	}

	public void addBook(Station station) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into station (sid,sname,pointX,pointY)values(?,?,?,?)", station.getSid(),station.getSname(),station.getPointX(),station.getPointY());
	}

	public void deleteStation(String sid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update(ManagerThreadLocal.getConnection(),"delete from station where sid=?", sid);
	}

	public void batchDeleteBook(String[] ids) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[ids.length][];
		for(int i = 0;i<ids.length;i++){
			params[i] =new Object[]{ids[i]};
		}
		qr.batch("delete from station where sid=?", params);
	}

	public Station findStationById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return  qr.query("select * from station where sid=?", new BeanHandler<Station>(Station.class), id);
		
	}

	public boolean updateStation(String sid, String sname)  {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		try{
		qr.update("update station set sname=? where sid=?", sname,sid);
		return true;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public List<Station> searchStation(String sid, String sname) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		String sql = "select * from station where 1=1";
		List list =new ArrayList();
		if(sid!=""){
			sql+=" and sid like ?";
			list.add("%"+sid.trim()+"%");
		}
		if(sname!=""){
			sql+=" and sname like ?";
			list.add("%"+sname.trim()+"%");
		}
		return qr.query(sql, new BeanListHandler<Station>(Station.class), list.toArray());
	}

	public String findSidBySname(String sname) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (String) qr.query("select sid from station where sname=?", new ScalarHandler(),sname);
	}

	
}
