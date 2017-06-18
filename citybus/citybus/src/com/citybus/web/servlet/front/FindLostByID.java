package com.citybus.web.servlet.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Things;
import com.citybus.service.impl.ThingServiceImpl;




public class FindLostByID extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ID = request.getParameter("aid");
		ThingServiceImpl tsi = new ThingServiceImpl();
		List<Things> list =  tsi.findByID(ID);
		if(list!=null&&list.size()!=0){
			request.setAttribute("things", list.get(0));
			request.getRequestDispatcher("/detailGotThing.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
