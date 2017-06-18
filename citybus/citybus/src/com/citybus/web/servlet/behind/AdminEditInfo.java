package com.citybus.web.servlet.behind;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Admin;
import com.citybus.service.impl.AdminServiceImpl;

public class AdminEditInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String oldpwd=request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		//System.out.println(admin.getAdminPass());
		if(oldpwd!=admin.getAdminPass()){
			request.setAttribute("ckcode_msg", "æ…√‹¬Î ‰»Î¥ÌŒÛ£°");
			request.getRequestDispatcher("/admin/system/editpwd.jsp").forward(request, response);
		}else{
			AdminServiceImpl asi = new AdminServiceImpl();
			admin=asi.login(admin);
			admin.setAdminPass(newpwd);
			int i = asi.updatePwd(admin);
			if(i>0){
				request.getRequestDispatcher(request.getContextPath()+"/adminLogin1.jsp").forward(request, response);
			}else{
				
				request.setAttribute("ckcode_msg", "√‹¬Î–ﬁ∏ƒ ß∞‹£°");
				request.getRequestDispatcher("/admin/system/editpwd.jsp").forward(request, response);
			}
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
