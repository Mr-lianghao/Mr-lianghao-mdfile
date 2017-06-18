package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.dao.LineStationDaoImpl;
import com.citybus.domain.Line;
import com.citybus.domain.LineLeftStation;
import com.citybus.domain.Station;
import com.citybus.service.impl.LineServiceImpl;
import com.citybus.service.impl.LineStationServiceImpl;
import com.citybus.service.impl.StationServiceImpl;

public class FindRouteById extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 思路：
		 * 1.传入的是lname
		 * 2.根据lname先获取线路的信息，存入到list1中，用于现实在上面的信息中
		 * 3.根据lname获取线路中的站点，存入到list2中，用于显示在右边的select中
		 * 4.查找所有的站点，存入到list3中，用于显示在左边的select中
		 */
		//response.setContentType("text/html;charset=UTF-8");
		String lname = request.getParameter("lname");
		lname= new String(lname.getBytes("ISO-8859-1"),"UTF-8");
		//System.out.println("lname1="+lname);
		//获取line中的信息
		LineServiceImpl lsi = new LineServiceImpl();
		Line line = lsi.finLineByLname(lname);
		//------------------------------------------
		//根据lname获取该线路的所有站点列表
		LineStationServiceImpl lss = new LineStationServiceImpl();
		//获取的是st1中表的线路中各个站点的顺序---存入到list中--右边的select中
		List<LineLeftStation> listOrde = lss.finRouteById(lname);
		
		//获取所有站点
		StationServiceImpl ssi = new StationServiceImpl();
		List<Station> listStation = ssi.findAllStation();
		
		//存入域中
		request.setAttribute("line", line);
		request.setAttribute("listStation", listStation);
		//咱们应该获取全部的站点，显示在左边的列表中
		request.setAttribute("listOrde", listOrde);
		request.getRequestDispatcher("/admin/products/addlinestation.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
