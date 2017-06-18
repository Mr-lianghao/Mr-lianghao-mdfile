package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.StationServiceImpl;

public class BatchDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取
		String[] ids = request.getParameterValues("ids");
		
		/*for(int i = 0;i<ids.length;i++){
			System.out.println(ids[i]);
		}*/
		//处理逻辑
		StationServiceImpl ss = new StationServiceImpl();
		try {
			ss.batchDeleteBook(ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//chongdingxiang
		request.getRequestDispatcher("/servlet/stationListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
