package com.citybus.web.servlet.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.PageBean_News;
import com.citybus.domain.PageBean_Things;
import com.citybus.service.impl.NewServiceImpl;
import com.citybus.service.impl.ThingServiceImpl;

public class FindLostByName extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String thing_name = request.getParameter("name");
		String currPage = request.getParameter("currentPage");
		if(thing_name!=null){
			thing_name = new String(thing_name.getBytes("ISO-8859-1"),"UTF-8");
		}
		int pageSize=6;
		int currentPage=1;
		if(currPage!=null&&!"".equals(currPage)){
			currentPage=Integer.parseInt(currPage);
		}
		//处理逻辑业务
		ThingServiceImpl tsi = new ThingServiceImpl();
		PageBean_Things pbn = tsi.finNewsByTitle(thing_name,currentPage,pageSize);
		request.setAttribute("pbn", pbn);
		request.getRequestDispatcher("/thingAll_search.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
