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
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String name=req.getParameter("name");
		//System.out.println("拿到的name："+name);
				
		//处理请求信息
			//获取业务层对象
		UserService us=new UserServiceImpl();
		User u=(User) us.getUserInfoService(name);
		//System.out.println("到了这一步");
		System.out.println("打印"+u);
		//响应请求信息
		resp.getWriter().write("{uid:'"+u.getUid()+"',name:'"+u.getName()+"',power:'"+u.getPower()+"',money:'"+u.getMoney()+"',loca:'"+u.getLoca()+"',dec:'"+u.getDec()+"'}");
		//resp.getWriter().write("测试一下是不是有数据");
	}
}
