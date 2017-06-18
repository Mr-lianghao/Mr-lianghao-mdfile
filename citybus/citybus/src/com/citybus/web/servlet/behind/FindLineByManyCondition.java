package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Line;
import com.citybus.service.impl.LineServiceImpl;

public class FindLineByManyCondition extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//接收数据
		String lname = request.getParameter("lname");
		String company = request.getParameter("company");
		String people = request.getParameter("people");
		String type = request.getParameter("type");
		
		System.out.println(lname);
		//处理逻辑
		LineServiceImpl lsi = new LineServiceImpl();
		List<Line> list = lsi.searchLine(lname,company,people,type);
		
		request.setAttribute("line", list);
		
		request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
