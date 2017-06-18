package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.AdminServiceImpl;

public class DelAdminById extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		AdminServiceImpl asi = new AdminServiceImpl();
		int i = asi.delAdminById(id);
		if(i==0){
			request.setAttribute("req_msg", "É¾³ýÊ§°Ü£¡");
			request.getRequestDispatcher("/servlet/findAdminAll").forward(request, response);
		}else{
			request.setAttribute("req_msg", "É¾³ý³É¹¦£¡");
			request.getRequestDispatcher("/servlet/findAdminAll").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
