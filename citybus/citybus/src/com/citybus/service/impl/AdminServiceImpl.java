package com.citybus.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.citybus.dao.AdminDaoImpl;
import com.citybus.domain.Admin;

public class AdminServiceImpl {

	AdminDaoImpl adi= new AdminDaoImpl();
	public Admin login(Admin admin) {
			try {
				return adi.login(admin);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			
			
	}
	public int updatePwd( Admin admin) {
		try {
			return adi.updatePwd(admin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public List<Admin> findAllAdmin() {
		try {
			return adi.findAllAdmin();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int addAdmin(Admin admin) {
		try {
			Admin a =adi.findAdminByName(admin.getAdminName());
			if(a!=null){
				return 0;
			}
			return adi.addAdmin(admin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int delAdminById(String id) {
		try {
			return adi.delAdminById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
