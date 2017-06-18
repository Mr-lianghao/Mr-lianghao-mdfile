package com.citybus.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.citybus.domain.BusInfo;
import com.citybus.domain.News;
import com.citybus.domain.PageBean;
import com.citybus.domain.PageBean_GuestBook_Two;
import com.citybus.service.impl.GuestBookServiceImpl;
import com.citybus.service.impl.LineServiceImpl;
import com.citybus.service.impl.NewServiceImpl;

public class IndexFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		//接收数据
		//处理业务逻辑
		NewServiceImpl nsi = new NewServiceImpl();
		List<News> news = nsi.getTopNew();
		
		int pageSize=2;
		int currentPage=1;
		LineServiceImpl lsi = new LineServiceImpl();
		PageBean pb = lsi.findLinePage(pageSize, currentPage);  
		/*if(news!=null){
		for(News n:news){
			System.out.println(n.getNewstitle().toString());
		}
		}*/
		
		//查找留言，并分页
		GuestBookServiceImpl gbsi = new GuestBookServiceImpl();
		PageBean_GuestBook_Two pbg = gbsi.finGuestPage(currentPage,pageSize);
		
		//保存到域中
		request.setAttribute("pb", pb);
		request.setAttribute("news", news);
		request.setAttribute("pbg", pbg);
		chain.doFilter(request, response);
	}
	public void destroy() {
		// TODO Auto-generated method stub

	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
