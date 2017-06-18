package com.citybus.web.servlet.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.LineString;
import com.citybus.service.impl.LineStationServiceImpl;



public class FindLineByLname extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			
			String lname = request.getParameter("lname");
			lname = new String(lname.getBytes("ISO-8859-1"),"UTF-8");
			//处理业务
			LineStationServiceImpl lss = new LineStationServiceImpl();
			List<LineString> list = lss.searchLineStation1(lname);
			request.setAttribute("count", list.size());
			request.setAttribute("searchname", lname);
			if(list.size()!=0){
				request.setAttribute("list", list);
				request.getRequestDispatcher("/busSearch_listL.jsp").forward(request, response);
			}else{
				request.setAttribute("sname2", lname);
				request.getRequestDispatcher("/busSearch_listNo.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
