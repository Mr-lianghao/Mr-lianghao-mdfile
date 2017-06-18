package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Station;
import com.citybus.service.impl.StationServiceImpl;

public class FindStationByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("sid");
		
	
		StationServiceImpl bs = new StationServiceImpl();
		Station station = bs.findStationById(sid);
		
		
		request.setAttribute("station", station);
		request.getRequestDispatcher("/admin/products/StationEdit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
