package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.User;
import com.bjsxt.service.MethodService;
import com.bjsxt.service.Impl.MethodServiceImpl;

public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取信息
			//获取cookie信息
		//创建一个新的cookie对象
		Cookie[] cks=req.getCookies();
		if(cks!=null){
			String uid="";
			for (Cookie ck : cks) {
				if("uid".equals(ck.getName())){
					uid=ck.getValue();
				}
			}
			if("".equals(uid)){
				System.out.println("判断了一步就过来了");
				req.getRequestDispatcher("Method.jsp").forward(req, resp);
				return;
			}else{
				MethodService md=new MethodServiceImpl();
				User u=md.checkuidservice(uid);
				if(u!=null){
					System.out.println("判断好了");
					resp.sendRedirect("main");
					return;
				}else {
					//cookie为空，直接转发给method登录页面
					System.out.println("判断差了一步");
					req.getRequestDispatcher("Method.jsp").forward(req, resp);
					return;
				}
			}
		}else {
			//cookie为空，直接转发给method登录页面
			System.out.println("没有判断就直接过来了");
			req.getRequestDispatcher("Method.jsp").forward(req, resp);
			return;
		}
	}
}
