package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.citybus.domain.Admin;
import com.citybus.service.impl.AdminServiceImpl;

public class AdminLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理验证码
		request.setCharacterEncoding("UTF-8");
		String ckcode = request.getParameter("ckcode");
		//System.out.println(ckcode);
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		if(!checkcode_session.equals(ckcode)){//如果两个验证码不一致，跳回注册面
			request.setAttribute("ckcode_msg", "验证码错误！");
			request.getRequestDispatcher("/adminLogin1.jsp").forward(request, response);
			return ;
		}
		
		//获取表单数据
		Admin admin = new Admin();
		try {
			BeanUtils.populate(admin, request.getParameterMap());
			//调用业务逻辑
			AdminServiceImpl asi = new AdminServiceImpl();
			Admin ad = asi.login(admin);
			if(ad!=null){
				if(ad.getQuanxian()=="1"||"1".equals(ad.getQuanxian())){
				request.getSession().setAttribute("admin", ad);
				response.sendRedirect(request.getContextPath()+"/admin/login/home.jsp");
				}else{
					request.getSession().setAttribute("admin", ad);
					response.sendRedirect(request.getContextPath()+"/admin/login/home1.jsp");
				}
			}else{
				request.setAttribute("ckcode_msg", "用户名或密码输入有误！");
				request.getRequestDispatcher("/adminLogin1.jsp").forward(request, response);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
