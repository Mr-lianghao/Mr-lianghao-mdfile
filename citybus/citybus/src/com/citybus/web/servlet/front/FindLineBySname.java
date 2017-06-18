package com.citybus.web.servlet.front;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Line;
import com.citybus.domain.LineString;
import com.citybus.service.impl.LineStationServiceImpl;

public class FindLineBySname extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取sname并防止乱码
		String sname = request.getParameter("sname");
		//System.out.println(sname);
		sname = new String(sname.getBytes("ISO-8859-1"),"UTF-8");
		//业务处理
			LineStationServiceImpl lssi = new LineStationServiceImpl();
			List lname = lssi.findLnameBySname(sname);
			List<LineString> list = new ArrayList<LineString>();
			//System.out.println(lname.size());
			if(lname!=null){
				for(int i=0;i<lname.size();i++){
					Line lu=(Line) lname.get(i);
					LineString line = lssi.searchLineStation(lu.getLname());
					list.add(line);
					}
			}
			//System.out.println(list.get(0).getLname());
	/*
			for(LineString l:list){
				System.out.println(l.getLname());
			}*/
			//System.out.println(list.size());
			request.setAttribute("searchname", sname);
			request.setAttribute("count", list.size());
			if(list.size()!=0){
				request.setAttribute("list", list);
				request.getRequestDispatcher("/busSearch_listS.jsp").forward(request, response);
			}else{
				request.setAttribute("sname2", sname);
				request.getRequestDispatcher("/busSearch_listNo.jsp").forward(request, response);
			}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
