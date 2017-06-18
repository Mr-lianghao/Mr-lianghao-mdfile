package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.LineString;
import com.citybus.service.impl.LineStationServiceImpl;

public class FindLineStationByManyCondition extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取数据
		String sname = request.getParameter("lname");
		//处理业务
		LineStationServiceImpl lssi = new LineStationServiceImpl();
		List<LineString> list = lssi.searchLineStation1(sname);
		
		request.setAttribute("line", list);
		request.getRequestDispatcher("/admin/products/linestationlist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
