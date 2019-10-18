package com.qym.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qym.pojo.PageInfo;
import com.qym.service.FlowerService;
import com.qym.service.Impl.FlowerServiceImpl;

public class FlowerServlet extends HttpServlet {
	private FlowerService fs=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���õ�size��number
		//�˴��ж�һ���Ƿ���size��number
		String str1=req.getParameter("pageSize");
		//����Ĭ��ֵ,ÿҳ��ʾ3��
		int pageSize=4;
		if (str1!=null&&!str1.equals("")) {
			pageSize=Integer.parseInt(str1);
		}
		
		String str2=req.getParameter("pageNumber");
		//����Ĭ��ֵ,һ����ʾһҳ
		int pageNumber=1;
		if (str2!=null&&!str2.equals("")) {
			pageNumber=Integer.parseInt(str2);
		}
		
		PageInfo pi=fs.showAll(pageSize, pageNumber);
		System.out.println(pi);
		req.setAttribute("pi", pi);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
