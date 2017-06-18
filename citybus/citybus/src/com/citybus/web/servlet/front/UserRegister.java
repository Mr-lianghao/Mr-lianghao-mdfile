package com.citybus.web.servlet.front;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.citybus.domain.User;
import com.citybus.exception.UserException;
import com.citybus.service.impl.UserServiceImpl;

public class UserRegister extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//处理验证码
				request.setCharacterEncoding("UTF-8");
				String ckcode = request.getParameter("ckcode");
				//System.out.println(ckcode);
				String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
				if(!checkcode_session.equals(ckcode)){//如果两个验证码不一致，跳回注册面
					request.setAttribute("ckcode_msg", "验证码错误！");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
					return ;
				}
				//获取表单数据
				User user = new User();
				try {
					BeanUtils.populate(user, request.getParameterMap());
					if(request.getSession().getAttribute("user_img")!=null){
						user.setUser_img(request.getSession().getAttribute("user_img").toString());
					}
					request.getSession().invalidate();
					//调用业务逻辑
					UserServiceImpl us = new UserServiceImpl();
					us.regist(user);
					//分发转向
					//要求用户激活后才能登录，所以不能把用户信息保存session中
					//request.getSession().setAttribute("user", user);//把用户信息封装到session对象中
					//request.setAttribute("user", user);
					request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
					
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
