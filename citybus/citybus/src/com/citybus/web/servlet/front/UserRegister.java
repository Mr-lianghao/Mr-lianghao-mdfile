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
				//������֤��
				request.setCharacterEncoding("UTF-8");
				String ckcode = request.getParameter("ckcode");
				//System.out.println(ckcode);
				String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
				if(!checkcode_session.equals(ckcode)){//���������֤�벻һ�£�����ע����
					request.setAttribute("ckcode_msg", "��֤�����");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
					return ;
				}
				//��ȡ������
				User user = new User();
				try {
					BeanUtils.populate(user, request.getParameterMap());
					if(request.getSession().getAttribute("user_img")!=null){
						user.setUser_img(request.getSession().getAttribute("user_img").toString());
					}
					request.getSession().invalidate();
					//����ҵ���߼�
					UserServiceImpl us = new UserServiceImpl();
					us.regist(user);
					//�ַ�ת��
					//Ҫ���û��������ܵ�¼�����Բ��ܰ��û���Ϣ����session��
					//request.getSession().setAttribute("user", user);//���û���Ϣ��װ��session������
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
