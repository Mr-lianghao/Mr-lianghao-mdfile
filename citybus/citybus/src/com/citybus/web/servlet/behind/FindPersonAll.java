package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.PageBean_Person;
import com.citybus.service.impl.UserServiceImpl;


public class FindPersonAll extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//接收数据
				Object ckcode_msg = request.getAttribute("ckcode_msg");
				//处理业务
				int currentPage=1;
				int pageSize=5;
				String currPage = request.getParameter("currentPage");
				//System.out.println(currPage);
				
				if(currPage!=null||"".equals(currPage)){
					currentPage=Integer.parseInt(currPage);
				}
				UserServiceImpl nsi = new UserServiceImpl();
				PageBean_Person pbp = nsi.findAllPerson(currentPage,pageSize);
				for(int i = 0;i<pbp.getUser().size();i++){
					if(pbp.getUser().get(i).getNums()==null){
						pbp.getUser().get(i).setNums(0);
					}
					if(pbp.getUser().get(i).getLasttime()==null){
						pbp.getUser().get(i).setLasttime("该用户未登录！");
					}
				}
				request.setAttribute("ckcode_msg", ckcode_msg);
				request.setAttribute("pbp", pbp);
				request.getRequestDispatcher("/admin/renyuan/person.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
