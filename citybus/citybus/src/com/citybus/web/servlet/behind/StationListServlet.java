package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Station;
import com.citybus.service.impl.StationServiceImpl;


public class StationListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//调用 业务逻辑
		StationServiceImpl bsi = new StationServiceImpl();
		List<Station> list = bsi.findAllStation();
		
		//跳转页面
		if(list!=null){
			request.setAttribute("station", list);//把list放入到request对象中
			request.getRequestDispatcher("/admin/products/stationlist.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
