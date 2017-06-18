package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Line;
import com.citybus.service.impl.LineServiceImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class UpdateLineServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//防止中文乱码
		request.setCharacterEncoding("UTF-8");
		
		Line line = new Line();
		//接收数据，封装到Map集合
		try {
			BeanUtils.populate(line, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//处理业务逻辑
		LineServiceImpl lsi = new LineServiceImpl();
		lsi.updateLine(line);
		
		response.sendRedirect(request.getContextPath()+"/servlet/lineListServlet");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
