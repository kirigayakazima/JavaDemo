package com.qym.dao;

import java.util.List;

import com.qym.pojo.Flowers;

public interface FlowerDao {
	//数据访问层接口，定义显示所有花的方法，应该用list来做
	public List<Flowers> seleAll();
	//定义一个添加花的方法，使用普通的Flowers类方法来做
	public Flowers insertFlower(Flowers flower);
}
