package com.citybus.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.citybus.domain.User;
import com.citybus.util.C3P0Util;


public class UserDaoImpl {

	public void addUser(User user) throws SQLException {

		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into users (username,password,email,gender,regtime,user_img)values(?,?,?,?,?,?)", user.getUsername(),user.getPassword(),user.getEmail(),user.getGender(),user.getRegtime(),user.getUser_img());
	}

	public User searchUser(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return  qr.query("select * from users where username=? and password=?", new BeanHandler(User.class), username,password);
	}

	public User findUserById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from users where id=?", new BeanHandler<User>(User.class), id);
	}

	public int updateUser(User u) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.update("update users set email=? , password=? , gender=? , username=? , regtime=? , nums=? , lasttime=? , user_img=? where id=?", u.getEmail(),u.getPassword(),u.getGender(),u.getUsername(),u.getRegtime(),u.getNums(),u.getLasttime(),u.getUser_img(),u.getId());
	}

	public int count() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (Integer) qr.query("select count(*) from users ", new ScalarHandler());
	}

	public List<User> getPagePerson(int currentPage, int pageSize) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("exec sp_userpage ? , ?", new BeanListHandler<User>(User.class), currentPage,pageSize);
	}

	public int delUserById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.update("delete from users where id=?", id);
	}

	public User findUserByUserName(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from users where username=?", new BeanHandler<User>(User.class), username);
	}

}
