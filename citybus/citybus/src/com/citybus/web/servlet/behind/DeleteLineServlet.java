package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.LineServiceImpl;

public class DeleteLineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lid = request.getParameter("lid");
		
		//处理业务
		LineServiceImpl lsi = new LineServiceImpl();
		int i = lsi.deleteLineById(lid);
		if(i>0){
			request.setAttribute("admin_msg", "删除成功");
		}
		
		request.getRequestDispatcher("/servlet/lineListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
