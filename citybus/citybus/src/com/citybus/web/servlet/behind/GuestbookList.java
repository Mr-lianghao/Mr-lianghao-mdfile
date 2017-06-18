package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.GuestBook;
import com.citybus.domain.PageBean_GuestAndReplay;
import com.citybus.service.impl.GuestBookServiceImpl;

public class GuestbookList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				//获取数据--获取传递的页数
			Object ckcode_msg = request.getAttribute("ckcode_msg");
				String currPage = request.getParameter("currentPage");
				Object req_msg = request.getAttribute("req_msg");
				
				int currentPage=1;
				int pageSize=4;
				
				if(currPage!=null&&!"".equals(currPage)){
					currentPage=Integer.parseInt(currPage);
				}
		
		GuestBookServiceImpl gbsi = new GuestBookServiceImpl();
		PageBean_GuestAndReplay pbg = gbsi.findAllGuestBook(currentPage,pageSize);
		/*if(guestbook!=null){
			for(GuestBook g:guestbook){
				System.out.println(g.getEmail());
			}
		}*/
		request.setAttribute("ckcode_msg", ckcode_msg);
		request.setAttribute("pgb", pbg);
		request.getRequestDispatcher("/admin/guestbook/guestbookList.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
