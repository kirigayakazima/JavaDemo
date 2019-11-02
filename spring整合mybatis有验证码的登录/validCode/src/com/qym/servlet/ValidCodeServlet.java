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
		//����һ��ͼƬ
		BufferedImage image=new BufferedImage(200,100, BufferedImage.TYPE_INT_RGB);
		//����һ������Ļ���
		Graphics2D gra=image.createGraphics();
		
		//���û�����ɫ
		gra.setColor(Color.BLACK);
		//���ÿ�ʼ��������
		gra.fillRect(0, 0, 200, 100);
		
		//����һ��list�����������0-9����Ϊ��֤��
		List<Integer> list=new ArrayList<>();
		Random radom=new Random();
		for(int i=0;i<4;i++){
			list.add(radom.nextInt(10));
		}
		
		//������֤�����������
		Font font=new Font("����",Font.ITALIC|Font.BOLD,40);
		gra.setFont(font);
		//����һ�����ݴ��������ɫ
		Color[] colors=new Color[] {Color.BLACK,Color.RED,Color.BLUE,Color.YELLOW,Color.GREEN};
		for(int i=0;i<list.size();i++){
			gra.setColor(colors[radom.nextInt(colors.length)]);
			gra.drawString(list.get(i)+"", i*40, 70+(radom.nextInt(21)-10));
		}

		//������
		for (int i = 0; i < 2; i++) {
			gra.setColor(colors[radom.nextInt(colors.length)]);
			gra.drawLine(0, radom.nextInt(101), 200, radom.nextInt(101));
		}
		
		
		
		ServletOutputStream os=resp.getOutputStream();
		//������
		ImageIO.write(image, "jpg", os);
		
		//����֤��ŵ�session
		HttpSession session=req.getSession();
		session.setAttribute("code",""+list.get(0)+list.get(1)+list.get(2)+list.get(3));
	}
}
