package com.citybus.web.servlet.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.citybus.domain.PageBean;
import com.citybus.domain.Things;
import com.citybus.service.impl.LineServiceImpl;
import com.citybus.service.impl.ThingServiceImpl;

public class AddThing extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		System.out.println(flag);
		Map parameterMap = request.getParameterMap();
		Things things = new Things();
		ThingServiceImpl tingsService = new ThingServiceImpl();
		try {
			BeanUtils.populate(things, parameterMap);
			things.setState(1);
			tingsService.insert(things);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
