package com.citybus.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.citybus.domain.Line;
import com.citybus.domain.LineLeftStation;
import com.citybus.domain.LineStation;
import com.citybus.domain.LineString;
import com.citybus.domain.Station;
import com.citybus.util.C3P0Util;
import com.citybus.util.ManagerThreadLocal;

public class LineStationDaoImpl {

	public List<LineLeftStation> findAllLineStation() throws SQLException {
		String sql="select distinct lname,type,company,people,tel from st1";
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query(sql, new BeanListHandler<LineLeftStation>(LineLeftStation.class));
	}

	public List<LineLeftStation> finRouteById(String string) throws SQLException {
		String sql="select * from st1 where lname=? order by orde";
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query(sql, new BeanListHandler<LineLeftStation>(LineLeftStation.class),string);
	}

	public List<LineLeftStation> finRouteByLname(String lname) throws SQLException {
		String sql="select * from st1 where lname=?";
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query(sql, new BeanListHandler<LineLeftStation>(LineLeftStation.class),lname);
	
	}

	public List<LineString> findAllLineString() throws SQLException {
		String sql="select * from getallstation";
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query(sql, new BeanListHandler<LineString>(LineString.class));
	}

	public LineString searchLineStation(String string) throws SQLException {
		String sql = "select * from getallstation where lname=?";
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query(sql, new BeanHandler<LineString>(LineString.class), string);
	}
	public int searchLineStationCount(String string) throws SQLException {
		String sql = "select count(*) from getallstation where lname=?";
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (Integer) qr.query(sql, new ScalarHandler(), string);
	}
	public List<LineString> searchLineStation1(String string) throws SQLException {
		String sql = "select * from getallstation where 1=1";
		List list = new ArrayList();
		if(!"".equals(string)){
			sql+=" and lname like ?";
			list.add("%"+string.trim()+"%");
		}
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query(sql, new BeanListHandler<LineString>(LineString.class), list.toArray());
	}

	public List findStationOnAJAX(List sql) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql1 = "select sname from station where 1=1";
		for(int i=0;i<sql.size();i++){
			sql1+=" and sid != ?";
		}
		List a = qr.query(sql1, new ColumnListHandler(),sql.toArray());
		/*System.out.println("-------------------------");*/
		//System.out.println(sql1);
		/*for(int i=0;i<a.size();i++){
			System.out.println(a.get(i));
		}*/
		return a;
	}

	public String finLidByLname(String lname) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (String) qr.query("select lid from line where lname=?", new ScalarHandler(),lname);
	}

	public List finSidByLid(String lid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select sid from stationline where lid=?", new ColumnListHandler(),lid);
	}

	public Station finStationByname(String name) throws SQLException {

		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from station where sname=?", new BeanHandler<Station>(Station.class), name);
		
	}

	public String findStationBySid(Object object) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (String) qr.query("select sname from station where sid=?", new ScalarHandler(), object);
	}

	public List findOrdeByLid(String lid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select orde from stationline where lid=?", new ColumnListHandler(), lid);
	}

	public void insertStationLine(String sid, String lid, String orde, String id) throws Exception {

		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "insert into stationline (sid,lid,orde)values(?,?,?)";
		qr.update(sql,sid,lid,orde);
	}

	public void updateSid(String orde, String lid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		String sql = "update stationline set orde=orde+1 where lid=? and orde>=?";
		qr.update(sql, lid,orde);
		
	}

	public void updateStationOnLine(String lid, String sname, String orde) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "update stationline set sname=? where lid=? and orde=?";
		qr.update(sql, sname,lid,orde);
	}

	public void delStation(String orde, String lid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "delete from stationline where lid=? and orde=?";
		qr.update(sql, lid,orde);
	}

	public void updateSidJ(String orde, String lid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "update stationline set orde=orde-1 where lid=? and orde>=?";
		qr.update(sql, lid,orde);
	}

	public void batchUpdateOrde(Object[][] obj) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql ="update stationline set sid=? where orde=? and lid=?";
		int[] batch = qr.batch(sql, obj);
	}
	public void insertStationLine(Object[][] obj) throws SQLException {
		for(int i=0;i<obj.length;i++){
			for(int j=0;j<3;j++){
				System.out.print(obj[i][j]+",");
			}
			System.out.println();
			System.out.println("_--------");
		}
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql ="insert into stationline (sid,orde,lid)values(?,?,?)";
		int[] batch = qr.batch(ManagerThreadLocal.getConnection(),sql, obj);
	}


	public List findLidBySid(String startSid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select lid from stationline where sid=?", new ColumnListHandler(),startSid);
	}

	public String findLnameByLid(String lid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (String) qr.query("select lname from line where lid=?", new ScalarHandler(), lid);
		
	}

	public String findRoutListByLname(String lname) throws SQLException {
		//select * from getallstation where 1=1
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (String) qr.query("select stationlist from getallstation where lname=?", new ScalarHandler(), lname);
	}

	public int findOrdeBySidAndLid(String startSid, String string) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (Integer) qr.query("select orde from stationline where sid=? and lid=?", new ScalarHandler(), startSid,string);
	}

	public int delLineByLid(String lid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.update(ManagerThreadLocal.getConnection(),"delete from stationline where lid=?", lid);
	}

	public List<LineStation> findOrdeBySid(String sid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from stationline where sid=?", new BeanListHandler<LineStation>(LineStation.class), sid);
	}

	public void deleteStation(String sid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		 qr.update(ManagerThreadLocal.getConnection(),"delete from stationline where sid=?", sid);
	}

	public void updateOrde(LineStation lstation) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		 qr.update(ManagerThreadLocal.getConnection(),"update stationline set orde=? where lid=? and orde>?",lstation.getOrde()-1,lstation.getLid(),lstation.getOrde() );
	}

	

}
