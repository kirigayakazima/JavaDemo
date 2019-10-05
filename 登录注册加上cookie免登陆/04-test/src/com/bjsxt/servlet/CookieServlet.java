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
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ��Ϣ
			//��ȡcookie��Ϣ
		//����һ���µ�cookie����
		Cookie[] cks=req.getCookies();
		if(cks!=null){
			String uid="";
			for (Cookie ck : cks) {
				if("uid".equals(ck.getName())){
					uid=ck.getValue();
				}
			}
			if("".equals(uid)){
				System.out.println("�ж���һ���͹�����");
				req.getRequestDispatcher("Method.jsp").forward(req, resp);
				return;
			}else{
				MethodService md=new MethodServiceImpl();
				User u=md.checkuidservice(uid);
				if(u!=null){
					System.out.println("�жϺ���");
					resp.sendRedirect("main");
					return;
				}else {
					//cookieΪ�գ�ֱ��ת����method��¼ҳ��
					System.out.println("�жϲ���һ��");
					req.getRequestDispatcher("Method.jsp").forward(req, resp);
					return;
				}
			}
		}else {
			//cookieΪ�գ�ֱ��ת����method��¼ҳ��
			System.out.println("û���жϾ�ֱ�ӹ�����");
			req.getRequestDispatcher("Method.jsp").forward(req, resp);
			return;
		}
	}
}
