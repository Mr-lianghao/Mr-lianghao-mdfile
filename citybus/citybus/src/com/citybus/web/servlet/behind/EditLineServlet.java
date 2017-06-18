package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Line;
import com.citybus.service.impl.LineServiceImpl;

public class EditLineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lid = request.getParameter("lid");

		LineServiceImpl bsi = new LineServiceImpl();
		Line line = bsi.findLineById(lid);
		
		request.setAttribute("line", line);
		
		request.getRequestDispatcher("/admin/products/editLine.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
