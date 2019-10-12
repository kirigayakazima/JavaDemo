package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.service.UserService;
import com.bjsxt.service.Impl.UserServiceImpl;
import com.bjsxt.vo.User;

public class UserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
		String name=req.getParameter("name");
		//System.out.println("�õ���name��"+name);
				
		//����������Ϣ
			//��ȡҵ������
		UserService us=new UserServiceImpl();
		User u=(User) us.getUserInfoService(name);
		//System.out.println("������һ��");
		System.out.println("��ӡ"+u);
		//��Ӧ������Ϣ
		resp.getWriter().write("{uid:'"+u.getUid()+"',name:'"+u.getName()+"',power:'"+u.getPower()+"',money:'"+u.getMoney()+"',loca:'"+u.getLoca()+"',dec:'"+u.getDec()+"'}");
		//resp.getWriter().write("����һ���ǲ���������");
	}
}
