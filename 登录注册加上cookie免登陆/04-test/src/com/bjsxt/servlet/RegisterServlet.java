package com.bjsxt.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.dao.RegisterDao;
import com.bjsxt.pojo.User;
import com.bjsxt.service.RegisterService;
import com.bjsxt.service.Impl.RegisterServiceImpl;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String rname=req.getParameter("rname");
		String rpwd=req.getParameter("rpwd");
		System.out.println("�˺ţ�"+rname);
		System.out.println("���룺"+rpwd);
		RegisterService rs=new RegisterServiceImpl();
		User u=rs.checkregisterservice(rname, rpwd);
		if(u!=null){
			resp.getWriter().write("register is successful");
			System.out.println("ע��ɹ�");
		}else{
			//resp.getWriter().write("register is failed");
			req.getRequestDispatcher("Register.jsp").forward(req, resp);
			return;
			//System.out.println("����ͬ���Ƶ��˺ţ�ע��ʧ��");
		}
	}
}
