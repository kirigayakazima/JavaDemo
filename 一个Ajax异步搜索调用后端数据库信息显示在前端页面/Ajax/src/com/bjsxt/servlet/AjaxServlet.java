package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		//��Ӧ������
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().write("��̬��ʾ�ɹ���");
	}
}
