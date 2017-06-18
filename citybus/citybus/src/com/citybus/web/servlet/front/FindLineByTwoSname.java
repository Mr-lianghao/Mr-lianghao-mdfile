package com.citybus.web.servlet.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.TransInfo;
import com.citybus.service.impl.LineStationServiceImpl;

public class FindLineByTwoSname extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String startStation = request.getParameter("sname1");
		String endStation = request.getParameter("sname2");
		startStation = new String(startStation.getBytes("ISO-8859-1"),"UTF-8");
		endStation = new String(endStation.getBytes("ISO-8859-1"),"UTF-8");
		
		//处理逻辑业务
		LineStationServiceImpl lssi = new LineStationServiceImpl();
		List<TransInfo> list = lssi.FindLineByTwoSname(startStation,endStation);
		request.setAttribute("sname1", startStation);
		request.setAttribute("sname2", endStation);
		if(list.size()>0){
		if(list.get(0).getLineString().size()!=0){
				int num=list.get(0).getLineString().size();
				//转发
				
				request.setAttribute("list", list);
				if(num==1){
					//System.out.println(list.get(0).getLineString().get(0));
					request.getRequestDispatcher("/busSearch_listZ.jsp").forward(request, response);
				}else if(num==2){
					request.getRequestDispatcher("/busSearch_listT.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/busSearch_listNo.jsp").forward(request, response);
				}
		}
		}else{
		request.getRequestDispatcher("/busSearch_listNo.jsp").forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
