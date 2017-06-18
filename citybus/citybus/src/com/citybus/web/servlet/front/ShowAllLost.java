package com.citybus.web.servlet.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.PageBean_News;
import com.citybus.domain.PageBean_Things;
import com.citybus.domain.Things;
import com.citybus.service.impl.ThingServiceImpl;
import com.citybus.service.impl.UserServiceImpl;

public class ShowAllLost extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage=1;
		int pageSize=5;
		String currPage = request.getParameter("currentPage");
		
		if(currPage!=null||"".equals(currPage)){
			currentPage=Integer.parseInt(currPage);
		}
		ThingServiceImpl thingsService = new ThingServiceImpl();
		PageBean_Things pbt = thingsService.findAllNews(currentPage,pageSize);
		request.setAttribute("pbt", pbt);
		request.getRequestDispatcher("/allLostThings.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
