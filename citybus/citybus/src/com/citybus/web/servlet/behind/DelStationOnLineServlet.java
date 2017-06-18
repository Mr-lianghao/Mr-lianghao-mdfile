package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.LineStationServiceImpl;

public class DelStationOnLineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取
		String orde = request.getParameter("orde");
		String lname = request.getParameter("lname");
		
		//转码
		orde = new String(orde.getBytes("ISO-8859-1"),"UTF-8");
		lname = new String(lname.getBytes("ISO-8859-1"),"UTF-8");
		
		//处理业务
		LineStationServiceImpl lssi = new LineStationServiceImpl();
		lssi.delStation(orde,lname);
		request.setAttribute("lname", lname);
		request.getRequestDispatcher("/servlet/findRouteById?lname"+lname).forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/servlet/findRouteById");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
