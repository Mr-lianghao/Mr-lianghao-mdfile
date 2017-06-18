package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.LineStationServiceImpl;

public class ChangeStationNameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取
		String sname = request.getParameter("sname");
		String lname = request.getParameter("lname");
		String orde = request.getParameter("orde");
		
		//转码
		sname = new String(sname.getBytes("ISO-8859-1"),"utf-8");
		lname = new String(lname.getBytes("ISO-8859-1"),"utf-8");
		orde = new String(orde.getBytes("ISO-8859-1"),"utf-8");
		
		//System.out.println(sname+""+lname+""+orde);
		
		//处理业务
		LineStationServiceImpl lssi = new LineStationServiceImpl();
		lssi.updateStationOnLine(sname,lname,orde);
		
		request.getRequestDispatcher("/servlet/findRouteById?lname="+lname).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
