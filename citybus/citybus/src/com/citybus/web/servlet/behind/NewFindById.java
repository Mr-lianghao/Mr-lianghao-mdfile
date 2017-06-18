package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.News;
import com.citybus.service.impl.NewServiceImpl;

public class NewFindById extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收数据
				String id = request.getParameter("id");
				//防止乱码
				id = new String(id.getBytes("ISO-8859-1"),"UTF-8");
				
				//System.out.println(id+"=id");
				NewServiceImpl nsi = new NewServiceImpl();
				News news = nsi.findNewsById(id);
				
				//System.out.println(news.getNewstitle());
				
				request.setAttribute("news", news);
				request.getRequestDispatcher("/admin/gonggao/gonggaoEdit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
