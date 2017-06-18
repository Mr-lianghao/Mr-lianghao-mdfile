package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.citybus.service.impl.StationServiceImpl;
import com.citybus.util.UUIDUtil;

public class DeleteStationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		
		//µ÷ÓÃÂß¼­
		StationServiceImpl ss = new StationServiceImpl();
		ss.deleteStation(sid);
		
		request.getRequestDispatcher("/servlet/stationListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
