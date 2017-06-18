package com.citybus.web.servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.UserServiceImpl;

public class CkUserName extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取数据
		String username = request.getParameter("username");
		//转码
		username=new String(username.getBytes("ISO-8859-1"),"utf-8");
		//System.out.println(username);
		//处理业务
		UserServiceImpl usi = new UserServiceImpl();
		boolean b = usi.findUserByUserName(username);
		response.getWriter().print(b);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
