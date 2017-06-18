package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.PageBean_News;
import com.citybus.service.impl.NewServiceImpl;

public class FindNewsAll extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收数据
		Object ckcode_msg = request.getAttribute("ckcode_msg");
		//处理业务
		int currentPage=1;
		int pageSize=5;
		String currPage = request.getParameter("currentPage");
		//System.out.println(currPage);
		
		if(currPage!=null||"".equals(currPage)){
			currentPage=Integer.parseInt(currPage);
		}
		NewServiceImpl nsi = new NewServiceImpl();
		PageBean_News pbn = nsi.findAllNews(currentPage,pageSize);
		/*for(int i = 0;i<pbn.getNews().size();i++){
			System.out.println(pbn.getNews().get(i).getNewstitle());
		}*/
		request.setAttribute("ckcode_msg", ckcode_msg);
		request.setAttribute("pbn", pbn);
		request.getRequestDispatcher("/admin/gonggao/gonggaoList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
