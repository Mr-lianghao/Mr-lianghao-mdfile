package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Line;
import com.citybus.service.impl.LineServiceImpl;



public class LineListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String admin_msg = (String) request.getAttribute("admin_msg");
		response.setContentType("text/html;charset=UTF-8");
		//���� ҵ���߼�
		LineServiceImpl bsi = new LineServiceImpl();
		List<Line> list = bsi.findAllLine();
		
		//��תҳ��
		if(list!=null){
			request.setAttribute("admin_msg", admin_msg);
			request.setAttribute("line", list);//��list���뵽request������
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
