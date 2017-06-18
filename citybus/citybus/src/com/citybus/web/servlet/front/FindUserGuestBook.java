package com.citybus.web.servlet.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.GuestAndReplay;
import com.citybus.domain.GuestBook_Left_Two;
import com.citybus.domain.PageBean_GuestAndReplay;
import com.citybus.domain.PageBean_GuestBook_Two;
import com.citybus.service.impl.GuestBookServiceImpl;

public class FindUserGuestBook extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		String currPage = request.getParameter("currentPage");
		//System.out.println(nickname);
		int currentPage=1;
		int pageSize=4;
		
		if(currPage!=null&&currPage!=""){
			currentPage=Integer.parseInt(currPage);
		}
		
		nickname=new String(nickname.getBytes("ISO-8859-1"),"UTF-8");
		
		GuestBookServiceImpl gbsi = new GuestBookServiceImpl();
		PageBean_GuestBook_Two pbg = gbsi.findGuestPageById(nickname,currentPage,pageSize);
		List<GuestBook_Left_Two> list = pbg.getList();
		/*if(list!=null){
			for(GuestAndReplay g:list){
				System.out.println(g.getNickname());
			}
		}*/
		request.setAttribute("pbg", pbg);
		request.getRequestDispatcher("/user/myGuestBook.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
