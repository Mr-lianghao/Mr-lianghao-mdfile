package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.GuestBookServiceImpl;

public class DelGuestbookById extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gid = request.getParameter("gid");
		
		GuestBookServiceImpl gbsi = new GuestBookServiceImpl();
		int i = gbsi.delGuestbookByGid(gid);
		if(i>0){
			
			request.setAttribute("ckcode_msg", "É¾³ý³É¹¦£¡");
			request.getRequestDispatcher("/servlet/guestbookList").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
