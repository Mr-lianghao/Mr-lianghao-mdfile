package com.citybus.web.servlet.behind;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.service.impl.LineStationServiceImpl;

public class CkStationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lname=request.getParameter("lname");
		String sname = request.getParameter("name");
		//System.out.println(lname);
		//解决乱码
		lname=new String(lname.getBytes("ISO-8859-1"),"utf-8");
		sname=new String(sname.getBytes("ISO-8859-1"),"utf-8");
		
		//lname=URLEncoder.encode(lname, "UTF-8");
		//System.out.println(lname);
		System.out.println(sname);
		//处理业务逻辑
		LineStationServiceImpl lssi = new LineStationServiceImpl();
		
		try {
			List b = lssi.findStationOnAJAX(sname, lname);
			if(b==null){
				response.getWriter().print(true);
				return;
			}
			for(int i=0;i<b.size();i++){
				if(sname.equals(b.get(i))){
					response.getWriter().print(false);
					return ;
				}
			}
			response.getWriter().print(true);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
