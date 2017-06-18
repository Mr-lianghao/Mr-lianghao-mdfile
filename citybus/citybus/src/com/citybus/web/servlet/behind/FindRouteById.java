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
		 * ˼·��
		 * 1.�������lname
		 * 2.����lname�Ȼ�ȡ��·����Ϣ�����뵽list1�У�������ʵ���������Ϣ��
		 * 3.����lname��ȡ��·�е�վ�㣬���뵽list2�У�������ʾ���ұߵ�select��
		 * 4.�������е�վ�㣬���뵽list3�У�������ʾ����ߵ�select��
		 */
		//response.setContentType("text/html;charset=UTF-8");
		String lname = request.getParameter("lname");
		lname= new String(lname.getBytes("ISO-8859-1"),"UTF-8");
		//System.out.println("lname1="+lname);
		//��ȡline�е���Ϣ
		LineServiceImpl lsi = new LineServiceImpl();
		Line line = lsi.finLineByLname(lname);
		//------------------------------------------
		//����lname��ȡ����·������վ���б�
		LineStationServiceImpl lss = new LineStationServiceImpl();
		//��ȡ����st1�б����·�и���վ���˳��---���뵽list��--�ұߵ�select��
		List<LineLeftStation> listOrde = lss.finRouteById(lname);
		
		//��ȡ����վ��
		StationServiceImpl ssi = new StationServiceImpl();
		List<Station> listStation = ssi.findAllStation();
		
		//��������
		request.setAttribute("line", line);
		request.setAttribute("listStation", listStation);
		//����Ӧ�û�ȡȫ����վ�㣬��ʾ����ߵ��б���
		request.setAttribute("listOrde", listOrde);
		request.getRequestDispatcher("/admin/products/addlinestation.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
