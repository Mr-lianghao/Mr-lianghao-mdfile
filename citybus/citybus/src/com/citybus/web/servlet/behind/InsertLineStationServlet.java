package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.LineStationServiceImpl;
/**
 * 插入、更新线路顺序
 * @author Administrator
 *
 */
public class InsertLineStationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] stationOrde = request.getParameterValues("stationOrde");
		String lid = request.getParameter("lid");
		String lname = request.getParameter("lname");
		System.out.println("lid="+lid);
		for(int i=0;i<stationOrde.length;i++){
			System.out.println(i+"="+stationOrde[i]);
		}
		//处理逻辑业务
		LineStationServiceImpl lssi = new LineStationServiceImpl();
		int i=lssi.insertStationLine(lid,stationOrde);
		
		request.getRequestDispatcher("/servlet/findRouteById?lname="+lname).forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
