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
	//定义一个局部变量，防止浪费资源
	PeopleService ps=new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		//拿到表单的sid
		int id=Integer.parseInt(req.getParameter("sid"));
		People p1=new People();
		p1.setId(id);
		People p2=ps.showPeople(p1);
		
		if (p2!=null) {
			//重定向到显示页面
			HttpSession session=req.getSession();
			session.setAttribute("p2", p2);
			System.out.println(p2);
			resp.sendRedirect("showOne.jsp");
		}
	}
}
