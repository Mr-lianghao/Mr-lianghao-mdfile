package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.LineServiceImpl;

public class BatchDeleteLineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] ids = request.getParameterValues("ids");
		
		//处理业务
		LineServiceImpl lsi = new LineServiceImpl();
		lsi.batchDeleteLine(ids);
		
		//重定向
		response.sendRedirect(request.getContextPath()+"/servlet/lineListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
