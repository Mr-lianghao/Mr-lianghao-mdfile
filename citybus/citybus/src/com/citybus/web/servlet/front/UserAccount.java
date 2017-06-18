package com.citybus.web.servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.User;

public class UserAccount extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从session中取出对象
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("user_msg", "请您先进行登陆操作！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/user/myAccount.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
