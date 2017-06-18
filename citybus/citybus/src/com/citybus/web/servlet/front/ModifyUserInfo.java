package com.citybus.web.servlet.front;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.User;
import com.citybus.service.impl.UserServiceImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ModifyUserInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("aa");
		request.setCharacterEncoding("UTF-8");
		
		User u = new User();
		//System.out.println(request.getSession().getAttribute("user_img"));
		try {
			BeanUtils.populate(u, request.getParameterMap());
			if(request.getSession().getAttribute("user_img")!=null){
				u.setUser_img(request.getSession().getAttribute("user_img").toString());
			}
			request.getSession().invalidate();
			//处理业务逻辑
			UserServiceImpl usi = new UserServiceImpl();
			int i = usi.updateUser(u);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().invalidate();//使session销毁
		//System.out.println(u.getEmail());
		//request.setAttribute("u", u);
		request.getRequestDispatcher("/user/modifyUserInfoSuccess.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
