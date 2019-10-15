package com.qym.service;

import java.util.List;

import com.qym.pojo.Flowers;

public interface FlowerService {
	//定义逻辑层的方法，调用数据访问层的seleAll方法，显示所有的花类
	public List<Flowers> showAll();
	//定义调用添加花类的方法
	public Flowers addFlower(Flowers flower);
}
