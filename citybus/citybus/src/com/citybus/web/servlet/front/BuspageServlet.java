package com.citybus.web.servlet.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Line;
import com.citybus.domain.PageBean;
import com.citybus.service.impl.LineServiceImpl;

public class BuspageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//������������б�������ʱ
		int pageSize = 4;
		int currentPage = 1;
		
		String currPage = request.getParameter("currentPage");
		if(currPage!=null&&!"".equals(currPage)){//��һ�η�����Դʱ��currPage������null
			currentPage = Integer.parseInt(currPage);
		}
		LineServiceImpl lsi = new LineServiceImpl();
		PageBean pb =  lsi.findLinePage(pageSize,currentPage);
		/*if(list!=null){
			for(Line line:list){
				System.out.println(line.getLname()+"=lname");
			}
		}*/
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/bus_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
