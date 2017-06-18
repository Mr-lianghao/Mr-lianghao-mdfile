package com.citybus.web.servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.User;
import com.citybus.service.impl.UserServiceImpl;

public class UserLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String lasttime = request.getParameter("lasttime");
		//解决cookie
		String ck=request.getParameter("ck");
		Cookie[] cookies = request.getCookies();
		if("on".equals(ck)){
				//构造Cookie对象，添加到Cookie中
				Cookie c = new Cookie("users1",username+"-"+password);
				c.setPath("/");
				//设置过期时间
				c.setMaxAge(60*60*60*24*7); 
				//存储
				response.addCookie(c);
		}else{
			for(int i=0;i<cookies.length;i++){
				if("users1".equals(cookies[i].getName())){
					
					cookies[i].setMaxAge(-1);
					cookies[i].setPath("/");
					response.addCookie(cookies[i]);
				}
			}
		}
		
		String names="";
		String pwd="";
		Cookie[] c1 = request.getCookies();
		for(int i=0;i<c1.length;i++){
			if("users1".equals(c1[i].getName())){
				//存储数据：用户名+密码
				names=c1[i].getValue().split("-")[0];
				pwd=c1[i].getValue().split("-")[1];
				System.out.println("pwd="+pwd);
			}
		}
		UserServiceImpl  usi = new UserServiceImpl();
		User user = usi.searchUser(username,password);
		//System.out.println(user.getNums());
		if(user!=null){
			user.setLasttime(lasttime);
			if(user.getNums()==null){
				user.setNums(1);
			}else{
				user.setNums(user.getNums()+1);
			}
			usi.updateUser(user);
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			request.setAttribute("user_msg", "输入的用户名或密码有误！,请重新登陆");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
