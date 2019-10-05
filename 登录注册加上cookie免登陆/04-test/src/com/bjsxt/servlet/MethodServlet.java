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
		//������������ʽ,����ǹ������ã���Ҫ��������ʽ�������ò�ͬ�ķ�ʽ�������post�� req.setCharacterEncoding("utf-8");
		
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		String uname=req.getParameter("uname");
		//���ܸ�ʽ��д��֮��Ϳ�����uname����д���Ľ���ע��
		uname=new String(uname.getBytes("iso8859-1"),"utf-8");
		String pwd=req.getParameter("pwd");
		System.out.println("�˺�:"+uname);
		System.out.println("����:"+pwd);
		MethodService lg=new MethodServiceImpl();
		User u=lg.checkloginservice(uname, pwd);
		System.out.println(u);
		String str=(String) req.getAttribute("str");
		if(u!=null){
			//resp.getWriter().write("login is successful");
			//��½�ɹ����uid����cookie����c��Ȼ�����c���cookie���ڴ浱��
			System.out.println("��¼ʱ���uid��"+u.getUid()+"");
			Cookie c=new Cookie("uid",u.getUid()+"");
			//���Ի���һСʱ���½
			c.setMaxAge(3600);
			c.setPath("/test/ck");
			resp.addCookie(c);
			resp.sendRedirect("/test/main");
			System.out.println("��½�ɹ���");
			return;
		}else{
			//resp.getWriter().write("login is failed");
			//ʵ�ֲ�ͬserVlet��������ת 
			req.setAttribute("str", "�û��������������");
			//ʹ������ת��
			System.out.println("������Method����");
			req.getRequestDispatcher("Method.jsp").forward(req, resp);
			return;
			//System.out.println("��½ʧ����");
		}
		
	}
}
