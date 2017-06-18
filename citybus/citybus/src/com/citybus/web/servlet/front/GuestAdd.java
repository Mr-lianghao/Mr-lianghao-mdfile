package com.citybus.web.servlet.front;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.GuestBook;
import com.citybus.service.impl.GuestBookServiceImpl;
import com.citybus.util.C3P0Util;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class GuestAdd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		GuestBookServiceImpl gbsi = new GuestBookServiceImpl();
		String nickname = request.getParameter("nickname");
		if(nickname==""){
			request.setAttribute("req_msg", "请您先进行登陆才能完成该操作！");
			request.getRequestDispatcher("/servlet/findGuestBookAll").forward(request, response);
		}else{
			GuestBook gb = new GuestBook();
			Map map =null;
			try {
				request.setAttribute("req_msg", "发布成功！");
				BeanUtils.populate(gb,  request.getParameterMap());
				//System.out.println("gid="+gb.getGid()+"-datetime="+gb.getAddtime());
				int i = gbsi.addGuest(gb);
				request.getRequestDispatcher("/servlet/findGuestBookAll").forward(request, response);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
