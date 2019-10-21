package com.qym.service.Impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qym.pojo.People;
import com.qym.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{
	@Override
	public People showPeople(People people) throws IOException {
		//首先获取资源
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		//先工厂模式创建一下对象
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		//开始操作mybatis
		People p1=session.selectOne("com.qym.mapper.PeopleMapper.seleOne",people);
		//操作第二个
		People p2=session.selectOne("com.qym.mapper.PeopleMapper.sele",5);
		System.out.println(p2);
		return p2;
	}

}
