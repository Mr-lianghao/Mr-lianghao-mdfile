package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.citybus.domain.Station;
import com.citybus.service.impl.StationServiceImpl;
import com.citybus.util.UUIDUtil;

public class AddStationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//��ȡ������
		Station station = new Station();
		try {
			BeanUtils.populate(station, request.getParameterMap());
			station.setSid(UUIDUtil.getUUID());//�ֶ�����һ�����ID
		} catch (Exception e) {
			e.printStackTrace();
		}
		//����ҵ���߼�
		StationServiceImpl bs = new StationServiceImpl();
		bs.addStation(station);
		
		//�ַ�ת��
								//��д/�������·��������ڱ����·��
		request.getRequestDispatcher("stationListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
