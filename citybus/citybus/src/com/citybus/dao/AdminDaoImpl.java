package com.citybus.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.citybus.domain.Admin;
import com.citybus.util.C3P0Util;

public class AdminDaoImpl {

	public Admin login(Admin admin) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (Admin) qr.query("select * from admin where adminName=? and adminPass=?", new BeanHandler<Admin>(Admin.class), admin.getAdminName(),admin.getAdminPass());
	}

	public int updatePwd(Admin admin) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());		
		return qr.update("update admin set adminName=? , adminPass=? ,  phone=? , registerTime=? where id=?", admin.getAdminName(),admin.getAdminPass(),admin.getPhone(),admin.getRegisterTime(),admin.getId());
	}

	public List<Admin> findAllAdmin() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return qr.query("select * from admin where quanxian <> ?", new BeanListHandler<Admin>(Admin.class), 1);
	}

	public int addAdmin(Admin admin) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return qr.update("insert into admin (adminName,adminPass,phone,registerTime,quanxian)values(? , ? , ? , ? , ?)", admin.getAdminName(),admin.getAdminPass(),admin.getPhone(),admin.getRegisterTime(),admin.getQuanxian());
	}

	public Admin findAdminByName(String adminName) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return qr.query("select * from admin where adminName=?", new BeanHandler<Admin>(Admin.class), adminName);
		
	}

	public int delAdminById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());	
		return qr.update("delete from admin where id=?", id);
	}

}
