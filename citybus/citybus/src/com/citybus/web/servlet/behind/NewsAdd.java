package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.News;
import com.citybus.service.impl.NewServiceImpl;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class NewsAdd extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			News news = new News();
			BeanUtils.populate(news, request.getParameterMap());
			//System.out.println(news.getNewstime());
			NewServiceImpl nsi = new NewServiceImpl();
			int i = nsi.insertNews(news);
			//System.out.println(i);
			if(i>0){
				
				request.setAttribute("ckcode_msg", "Ìí¼Ó³É¹¦£¡");
				request.getRequestDispatcher("/servlet/findNewsAll").forward(request, response);
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
