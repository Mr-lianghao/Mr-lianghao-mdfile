package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.GuestAndReplay;
import com.citybus.domain.GuestBook;
import com.citybus.service.impl.GuestBookServiceImpl;

public class GuestBookFindById extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gid = request.getParameter("id");
		//System.out.println(gid);
		String addtime = request.getParameter("addtime");
		//System.out.println(addtime);
		addtime = new String(addtime.getBytes("ISO-8859-1"),"UTF-8");
		
		//处理业务逻辑
		GuestBookServiceImpl gbsi = new GuestBookServiceImpl();
		GuestAndReplay gb = gbsi.finGuestByIdAndTime(gid,addtime);
		
		//System.out.println(gb.get);
			request.setAttribute("gb", gb);
			request.getRequestDispatcher("/admin/guestbook/replay.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
