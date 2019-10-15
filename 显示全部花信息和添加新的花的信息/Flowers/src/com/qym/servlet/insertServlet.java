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
	//减少资源占用
	FlowerService fs=null;
	String str="";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//调用逻辑层
		//出现了乱码，是没配置编码格式的原因
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		
		 
		fs=new FlowerServiceImpl();
		String uname=req.getParameter("uname");
		String price=req.getParameter("price");
		String production=req.getParameter("production");
		System.out.println("拿到了数据"+uname+"-----"+price+"------"+production);
		Flowers flower=new Flowers(0, uname, Double.parseDouble(price), production);
		Flowers f=fs.addFlower(flower);
		System.out.println("这一步是最后一步");
		if(f==null){
			
			str="添加失败，库中已经有该类花的样本";
			req.setAttribute("str", str);
			req.getRequestDispatcher("main/insert.jsp").forward(req, resp);
			return;
		}else {
			str="添加成功,系统将会在3s后为您跳转到显示页面";
			req.setAttribute("str", str);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//此时要使用重定向，请求转发会重复提交表单
			resp.sendRedirect("flower");
			return;
		}
	}
}
