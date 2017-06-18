package com.citybus.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.Admin;

public class AdminFilter implements Filter {

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Admin admin = (Admin) req.getSession().getAttribute("admin");
		if(admin!=null){
			chain.doFilter(request, response);
		}else{
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().write("对不起，该页面不存在！");
			resp.setHeader("refresh", "2;url="+req.getContextPath()+"/adminLogin1.jsp");
			return;
		}
		
		
	}
	public void destroy() {

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
