package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.UserServiceImpl;

public class DelUserById extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		UserServiceImpl usi = new UserServiceImpl();
		int i = usi.delUserById(id);
		if(i>0){
			request.setAttribute("ckcode_msg", "É¾³ý³É¹¦£¡");
			request.getRequestDispatcher("/servlet/findPersonAll").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
