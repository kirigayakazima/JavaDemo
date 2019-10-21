package com.qym.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Array;
import com.qym.pojo.People;
import com.qym.service.PeopleService;
import com.qym.service.Impl.PeopleServiceImpl;

public class PeopleServlet extends HttpServlet {
	//����һ���ֲ���������ֹ�˷���Դ
	PeopleService ps=new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ����ʽ
		req.setCharacterEncoding("utf-8");
		//�õ�����sid
		int id=Integer.parseInt(req.getParameter("sid"));
		People p1=new People();
		p1.setId(id);
		People p2=ps.showPeople(p1);
		
		if (p2!=null) {
			//�ض�����ʾҳ��
			HttpSession session=req.getSession();
			session.setAttribute("p2", p2);
			System.out.println(p2);
			resp.sendRedirect("showOne.jsp");
		}
	}
}
