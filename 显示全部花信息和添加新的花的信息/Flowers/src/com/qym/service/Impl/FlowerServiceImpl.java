package com.qym.service.Impl;

import java.util.List;

import com.qym.dao.FlowerDao;
import com.qym.dao.Impl.FlowerDaoImpl;
import com.qym.pojo.Flowers;
import com.qym.service.FlowerService;

public class FlowerServiceImpl implements FlowerService {
	//实现逻辑层的业务
	//定义一个私有的fd，这样就不会每次调用方法的时候都创建一个新的属性，浪费资源
	private FlowerDao fd=new FlowerDaoImpl();
	@Override
	public List<Flowers> showAll() {
		List<Flowers> list=fd.seleAll();
		return list;
	}
	@Override
	public Flowers addFlower(Flowers flower) {
		System.out.println("service开始运作");
		Flowers f=fd.insertFlower(flower);
		System.out.println(f+"是什么");
		return f;
	}
}
