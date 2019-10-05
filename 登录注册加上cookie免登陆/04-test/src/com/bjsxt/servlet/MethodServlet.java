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

public class MethodServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式,这个是公共配置，需要根据请求方式进行配置不同的方式，这个是post的 req.setCharacterEncoding("utf-8");
		
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		String uname=req.getParameter("uname");
		//万能格式，写了之后就可以在uname处填写中文进行注册
		uname=new String(uname.getBytes("iso8859-1"),"utf-8");
		String pwd=req.getParameter("pwd");
		System.out.println("账号:"+uname);
		System.out.println("密码:"+pwd);
		MethodService lg=new MethodServiceImpl();
		User u=lg.checkloginservice(uname, pwd);
		System.out.println(u);
		String str=(String) req.getAttribute("str");
		if(u!=null){
			//resp.getWriter().write("login is successful");
			//登陆成功后把uid当做cookie赋给c，然后添加c这个cookie到内存当中
			System.out.println("登录时候的uid："+u.getUid()+"");
			Cookie c=new Cookie("uid",u.getUid()+"");
			//测试环境一小时免登陆
			c.setMaxAge(3600);
			c.setPath("/test/ck");
			resp.addCookie(c);
			resp.sendRedirect("/test/main");
			System.out.println("登陆成功了");
			return;
		}else{
			//resp.getWriter().write("login is failed");
			//实现不同serVlet的数据流转 
			req.setAttribute("str", "用户名或者密码错误");
			//使用请求转发
			System.out.println("来到了Method里面");
			req.getRequestDispatcher("Method.jsp").forward(req, resp);
			return;
			//System.out.println("登陆失败了");
		}
		
	}
}
