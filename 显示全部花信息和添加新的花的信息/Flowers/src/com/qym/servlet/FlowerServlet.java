package com.qym.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qym.pojo.Flowers;
import com.qym.service.FlowerService;
import com.qym.service.Impl.FlowerServiceImpl;

public class FlowerServlet extends HttpServlet {
	//复写service方法，调用逻辑层
	//节省资源
	private FlowerService fl=null;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		fl=new FlowerServiceImpl();
		List<Flowers> list=fl.showAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("main/flower.jsp").forward(req, resp);
		for (Flowers f : list) {
				System.out.println(f);
			}
			System.out.println("数据拿过去了");
		}
	}
