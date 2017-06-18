package com.citybus.web.servlet.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.GuestAndReplay;
import com.citybus.domain.PageBean_GuestAndReplay;
import com.citybus.domain.PageBean_GuestBook_Two;
import com.citybus.service.impl.GuestBookServiceImpl;

public class FindGuestBookAll extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取数据--获取传递的页数
		String currPage = request.getParameter("currentPage");
		Object req_msg = request.getAttribute("req_msg");
		
		int currentPage=1;
		int pageSize=5;
		
		if(currPage!=null&&!"".equals(currPage)){
			currentPage=Integer.parseInt(currPage);
		}
		//业务处理
		GuestBookServiceImpl gbsi = new GuestBookServiceImpl();
		
		PageBean_GuestBook_Two pbg = gbsi.finGuestPage(currentPage,pageSize);
		//List<GuestAndReplay> list = gbsi.finAllGuestBookAndReplay();
		//request.setAttribute("list", list);
		/*for(int i=0;i<pbg.getList().size();i++){
			
			System.out.println("user_img:"+pbg.getList().get(i).getUser_img());
		}*/
		request.setAttribute("req_msg", req_msg);
		request.setAttribute("pbg", pbg);
		request.getRequestDispatcher("/guestbook.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
