package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.User;
import com.bjsxt.service.MethodService;
import com.bjsxt.service.Impl.MethodServiceImpl;

public class MethodServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		System.out.println("’À∫≈:"+uname);
		System.out.println("√‹¬Î:"+pwd);
		MethodService lg=new MethodServiceImpl();
		User u=lg.checkloginservice(uname, pwd);
		System.out.println(u);
		if(u!=null){
			resp.getWriter().write("login is successful");
			System.out.println("µ«¬Ω≥…π¶¡À");
		}else{
			resp.getWriter().write("login is failed");
			System.out.println("µ«¬Ω ß∞‹¡À");
		}
		
	}
}
