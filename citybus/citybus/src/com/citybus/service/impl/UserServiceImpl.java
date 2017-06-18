package com.citybus.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.citybus.dao.UserDaoImpl;
import com.citybus.domain.PageBean_Person;
import com.citybus.domain.User;

public class UserServiceImpl {

	UserDaoImpl udi = new UserDaoImpl();
	public void regist(User user) {
	
		try {
			udi.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User searchUser(String username, String password) {
		try {
			return udi.searchUser(username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public User findUserById(String id) {
		try {
			return udi.findUserById( id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int updateUser(User u) {
		try {
			return udi.updateUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public PageBean_Person findAllPerson(int currentPage, int pageSize) {
		try {
			PageBean_Person pbn = new PageBean_Person();
			//È¡³öcount
			int count = udi.count();
			int totalPage = (int) Math.ceil(count*1.0/pageSize);
			List<User> topPerson = udi.getPagePerson(currentPage,pageSize);
			
			pbn.setCount(count);
			pbn.setCurrentPage(currentPage);
			pbn.setUser(topPerson);
			pbn.setPageSize(pageSize);
			pbn.setTotalPage(totalPage);
			return pbn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	}
	public int delUserById(String id) {
		try {
			return udi.delUserById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public boolean findUserByUserName(String username) {
		try {
			User u = udi.findUserByUserName(username);
			if(u==null) return false;
			else return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
