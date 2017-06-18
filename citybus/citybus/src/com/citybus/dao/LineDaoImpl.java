package com.citybus.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.citybus.domain.Line;
import com.citybus.util.C3P0Util;
import com.citybus.util.ManagerThreadLocal;

public class LineDaoImpl {

	
	public List<Line> findAllLines() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from line", new BeanListHandler<Line>(Line.class));
	}

	public void addLine(Line line) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update(ManagerThreadLocal.getConnection(),"insert into line (lid,lname,type,company,people,tel,img_url)values(?,?,?,?,?,?,?)", line.getLid(),line.getLname(),line.getType(),line.getCompany(),line.getPeople(),line.getTel(),line.getImg_url());
	}

	public Line findLineById(String lid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from line where lid=?", new BeanHandler<Line>(Line.class),lid);
	}

	public void updateLine(Line line) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql="update line set lname=? , people=? , type=? , tel=? , company=? where lid=?";
		qr.update(sql, line.getLname(),line.getPeople(),line.getType(),line.getTel(),line.getCompany(),line.getLid());
		
	}

	public void deleteLineById(String lid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update(ManagerThreadLocal.getConnection(),"delete from line where lid=?", lid);
	}

	public void deleteLineById(String[] ids) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[ids.length][];
		for(int i = 0;i<ids.length;i++){
			params[i] =new Object[]{ids[i]};
		}
		qr.batch("delete from line where lid=?", params);
	}

	public List<Line> searchLine(String lname, String company, String people,
			String type) throws SQLException {
		String sql ="select * from line where 1=1";
		List list = new ArrayList();
		if(lname!=""){
			sql+=" and lname like ?";
			list.add("%"+lname.trim()+"%");
		}
		if(company!=""){
			sql+=" and compay like ?";
			list.add("%"+company.trim()+"%");
		}
		if(people!=""){
			sql+=" and people like ?";
			list.add("%"+people.trim()+"%");
		}
		if(type!=""){
			sql+=" and type like ?";
			list.add("%"+type.trim()+"%");
		}
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		 List<Line> list1 = qr.query(sql, new BeanListHandler<Line>(Line.class),list.toArray());
		 System.out.println(list1);
		 return list1;

	}

	public String getLidByLname(String lname) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (String) qr.query("select lid from line where lname=?", new ScalarHandler(), lname);
	}

	public String getLidBySid(String sid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (String) qr.query("select lid from line where sid=?", new ScalarHandler(), sid);
	}

	public List findLnameBySname(String sname) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select lname from st1 where sname=?", new BeanListHandler<Line>(Line.class), sname);
	}

	public List<Line> findLinePage(int pageSize, int currentPage) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("exec sp_page_not_in ?,? ", new BeanListHandler<Line>(Line.class),currentPage,pageSize);
		
	}

	public int count() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (Integer) qr.query("select count(*) from line", new ScalarHandler());
	}

	public void addLineIdTo(Line line) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update(ManagerThreadLocal.getConnection(),"insert into stationline (lid)values(?)",line.getLid());
	}

	public Line findLineByLname(String lname) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from line where lname=?", new BeanHandler<Line>(Line.class),lname);
	}
}
