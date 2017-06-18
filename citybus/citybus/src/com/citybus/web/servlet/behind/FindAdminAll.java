package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Admin;
import com.citybus.service.impl.AdminServiceImpl;

public class FindAdminAll extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String req_msg = (String) request.getAttribute("req_msg");
		//处理逻辑业务
		AdminServiceImpl as = new AdminServiceImpl();
		List<Admin> list = as.findAllAdmin();
		//转发
		request.setAttribute("req_msg", req_msg);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/renyuan/adminuser.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
