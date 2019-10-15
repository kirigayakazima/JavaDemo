package com.qym.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qym.pojo.Flowers;
import com.qym.service.FlowerService;
import com.qym.service.Impl.FlowerServiceImpl;


public class insertServlet extends HttpServlet {
	//������Դռ��
	FlowerService fs=null;
	String str="";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�����߼���
		//���������룬��û���ñ����ʽ��ԭ��
		//������������ʽ
		req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		
		 
		fs=new FlowerServiceImpl();
		String uname=req.getParameter("uname");
		String price=req.getParameter("price");
		String production=req.getParameter("production");
		System.out.println("�õ�������"+uname+"-----"+price+"------"+production);
		Flowers flower=new Flowers(0, uname, Double.parseDouble(price), production);
		Flowers f=fs.addFlower(flower);
		System.out.println("��һ�������һ��");
		if(f==null){
			
			str="���ʧ�ܣ������Ѿ��и��໨������";
			req.setAttribute("str", str);
			req.getRequestDispatcher("main/insert.jsp").forward(req, resp);
			return;
		}else {
			str="��ӳɹ�,ϵͳ������3s��Ϊ����ת����ʾҳ��";
			req.setAttribute("str", str);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��ʱҪʹ���ض�������ת�����ظ��ύ��
			resp.sendRedirect("flower");
			return;
		}
	}
}
