package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Admin;
import com.citybus.service.impl.AdminServiceImpl;

public class AddAdmin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String adminName = request.getParameter("adminName");
		String adminPass =request.getParameter("adminPass");
		String phone=request.getParameter("phone");
		String registerTime=request.getParameter("registerTime");
		
		Admin admin = new Admin();
		admin.setAdminName(adminName);
		admin.setAdminPass(adminPass);
		admin.setPhone(phone);
		admin.setRegisterTime(registerTime);
		admin.setQuanxian("2");
		
		AdminServiceImpl asi = new AdminServiceImpl();
		int i = asi.addAdmin(admin);
		if(i==0){
			request.setAttribute("req_msg", "对不起，该用户名已经存在！");
			request.getRequestDispatcher("/servlet/findAdminAll").forward(request, response);
		}else{
			request.setAttribute("req_msg", "添加成功！");
			request.getRequestDispatcher("/servlet/findAdminAll").forward(request, response);
			
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
