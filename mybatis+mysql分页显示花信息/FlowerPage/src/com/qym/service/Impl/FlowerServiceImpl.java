package com.qym.service.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qym.pojo.Flower;
import com.qym.pojo.PageInfo;
import com.qym.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{
	
	@Override
	public PageInfo showAll(int pageSize, int pageNumber) throws IOException {
		//获取资源
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		//拿到资源后进行建造者工厂模式生产
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		//打开资源
		SqlSession session=factory.openSession();
		//开始进行资源利用
		//创建一个map对象
		//创建一个新的pojo对象，存储分页信息
		PageInfo pi=new PageInfo();
		pi.setPageSize(pageSize);
		pi.setPageNumber(pageNumber);
		
		Map<String, Object> map=new HashMap<>();
		map.put("pageStart", pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		pi.setList(session.selectList("com.qym.mapper.FlowerMapper.selAll",map));
		long count=session.selectOne("com.qym.mapper.FlowerMapper.selByPage");
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}
}
