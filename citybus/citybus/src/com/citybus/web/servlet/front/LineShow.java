package com.citybus.web.servlet.front;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citybus.domain.LineLeftStation;
import com.citybus.service.impl.LineStationServiceImpl;

public class LineShow extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String lname = request.getParameter("lname");
		System.out.println(lname);
		//业务处理——LineLeftStation
		LineStationServiceImpl lssi = new LineStationServiceImpl();
		List<LineLeftStation> list = lssi.finRouteByLname(lname);
		
		List list1 = new ArrayList();
		List listS = new ArrayList();
        Comparator<LineLeftStation> comparator = new Comparator<LineLeftStation>() {
            public int compare(LineLeftStation s1, LineLeftStation s2) {
                    return s1.getOrde() - s2.getOrde();
            }
        };
        //如果不为空
        if(list!=null){
	        //对list进行排序，保证按顺序进行
	        Collections.sort(list, comparator);
	        for(int i=0;i<list.size();i++){
	        	String temp =list.get(i).getPointX().toString()+"|"+list.get(i).getPointY().toString();
				list1.add(temp);
				listS.add(list.get(i).getSname());
				System.out.println(temp);
	        }
        }
        request.setAttribute("req_msg", "没有找到线路！");
        request.setAttribute("lname", lname);
        request.setAttribute("list1", list1);
        request.setAttribute("listS", listS);
        request.getRequestDispatcher("/lineMap.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
