package com.qym.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import java.util.Random;

import javax.enterprise.inject.New;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidCodeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//创建一张图片
		BufferedImage image=new BufferedImage(200,100, BufferedImage.TYPE_INT_RGB);
		//设置一个画板的画笔
		Graphics2D gra=image.createGraphics();
		
		//设置画笔颜色
		gra.setColor(Color.BLACK);
		//设置开始填充的坐标
		gra.fillRect(0, 0, 200, 100);
		
		//增加一个list，生成随机数0-9，作为验证码
		List<Integer> list=new ArrayList<>();
		Random radom=new Random();
		for(int i=0;i<4;i++){
			list.add(radom.nextInt(10));
		}
		
		//设置验证码字体等属性
		Font font=new Font("宋体",Font.ITALIC|Font.BOLD,40);
		gra.setFont(font);
		//增加一个数据存放字体颜色
		Color[] colors=new Color[] {Color.BLACK,Color.RED,Color.BLUE,Color.YELLOW,Color.GREEN};
		for(int i=0;i<list.size();i++){
			gra.setColor(colors[radom.nextInt(colors.length)]);
			gra.drawString(list.get(i)+"", i*40, 70+(radom.nextInt(21)-10));
		}

		//划横线
		for (int i = 0; i < 2; i++) {
			gra.setColor(colors[radom.nextInt(colors.length)]);
			gra.drawLine(0, radom.nextInt(101), 200, radom.nextInt(101));
		}
		
		
		
		ServletOutputStream os=resp.getOutputStream();
		//工具类
		ImageIO.write(image, "jpg", os);
		
		//把验证码放到session
		HttpSession session=req.getSession();
		session.setAttribute("code",""+list.get(0)+list.get(1)+list.get(2)+list.get(3));
	}
}
