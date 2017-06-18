package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.LineString;
import com.citybus.service.impl.LineStationServiceImpl;


public class LineStationListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7389317247065801755L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//���� ҵ���߼�
		LineStationServiceImpl lsi = new LineStationServiceImpl();
		//List<LineLeftStation> list = lsi.findAllLineStation();
		List<LineString> lineString = lsi.findAllLineString();
		
		//Map<String, List> map = new HashMap<String, List>();
		//map.put("list", list);
		//map.put("lineString", lineString);
		
		
		//��תҳ��
		if(lineString!=null){
			request.setAttribute("line", lineString);//��list���뵽request������
			request.getRequestDispatcher("/admin/products/linestationlist.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
