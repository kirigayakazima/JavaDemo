package com.qym.service.Impl;

import java.util.List;

import com.qym.dao.FlowerDao;
import com.qym.dao.Impl.FlowerDaoImpl;
import com.qym.pojo.Flowers;
import com.qym.service.FlowerService;

public class FlowerServiceImpl implements FlowerService {
	//ʵ���߼����ҵ��
	//����һ��˽�е�fd�������Ͳ���ÿ�ε��÷�����ʱ�򶼴���һ���µ����ԣ��˷���Դ
	private FlowerDao fd=new FlowerDaoImpl();
	@Override
	public List<Flowers> showAll() {
		List<Flowers> list=fd.seleAll();
		return list;
	}
	@Override
	public Flowers addFlower(Flowers flower) {
		System.out.println("service��ʼ����");
		Flowers f=fd.insertFlower(flower);
		System.out.println(f+"��ʲô");
		return f;
	}
}
