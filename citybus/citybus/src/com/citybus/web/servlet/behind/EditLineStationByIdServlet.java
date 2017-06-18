package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.LineLeftStation;
import com.citybus.service.impl.LineStationServiceImpl;

public class EditLineStationByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lname = request.getParameter("lname");
		lname= new String(lname.getBytes("ISO-8859-1"),"UTF-8");
		
		LineStationServiceImpl lss = new LineStationServiceImpl();
		List<LineLeftStation> list = lss.finRouteByLname(lname);
		
		request.setAttribute("line", list);
		request.getRequestDispatcher("/admin/products/ChangeLineStation.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
