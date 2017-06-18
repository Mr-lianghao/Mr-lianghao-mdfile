package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Replay;
import com.citybus.service.impl.GuestBookServiceImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class GuestbookReplay extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Replay replay = new Replay();
		
		try {
			BeanUtils.populate(replay, request.getParameterMap());
			System.out.println(replay.getUsername());
			GuestBookServiceImpl gbsi = new GuestBookServiceImpl();
			int i = gbsi.addReplay(replay);
			if(i>0){
				
				request.setAttribute("ckcode_msg", "»Ø¸´³É¹¦£¡");
				request.getRequestDispatcher("/servlet/guestbookList").forward(request, response);
			}
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
