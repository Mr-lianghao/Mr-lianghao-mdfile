package com.citybus.web.servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.BusInfo;
import com.citybus.service.impl.LineStationServiceImpl;

public class BusInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String lid = request.getParameter("lid");
			
			LineStationServiceImpl lssi = new LineStationServiceImpl();
			BusInfo businfo = lssi.findBusInfoById(lid);
			
			request.setAttribute("businfo", businfo);
			request.getRequestDispatcher("/bus_info.jsp").forward(request, response);
			
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
