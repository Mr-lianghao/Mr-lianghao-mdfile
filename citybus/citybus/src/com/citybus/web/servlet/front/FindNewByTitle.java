package com.citybus.web.servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.PageBean_News;
import com.citybus.service.impl.NewServiceImpl;

public class FindNewByTitle extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newstitle = request.getParameter("newstitle");
		String currPage = request.getParameter("currentPage");
		newstitle = new String(newstitle.getBytes("ISO-8859-1"),"UTF-8");
		//System.out.println(newstitle+"=newstitle");
		
		int pageSize=6;
		int currentPage=1;
		if(currPage!=null&&!"".equals(currPage)){
			currentPage=Integer.parseInt(currPage);
		}
		//处理逻辑业务
		NewServiceImpl nsi = new NewServiceImpl();
		PageBean_News pbn = nsi.finNewsByTitle(newstitle,currentPage,pageSize);
		pbn.setNewstitle(newstitle);
		request.setAttribute("pbn", pbn);
		request.getRequestDispatcher("/NewAll_search.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
