package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Station;
import com.citybus.service.impl.StationServiceImpl;

public class FindStationByManyCondition extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//��������
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		
		//����ҵ��
		StationServiceImpl ssi = new StationServiceImpl();
		List<Station> station = ssi.searchStation(sid,sname);
		
		//�ַ�ת��
		request.setAttribute("station", station);
		
		request.getRequestDispatcher("/admin/products/stationlist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
