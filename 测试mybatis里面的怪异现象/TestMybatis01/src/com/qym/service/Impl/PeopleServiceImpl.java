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
		//���Ȼ�ȡ��Դ
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		//�ȹ���ģʽ����һ�¶���
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		//��ʼ����mybatis
		People p1=session.selectOne("com.qym.mapper.PeopleMapper.seleOne",people);
		//�����ڶ���
		People p2=session.selectOne("com.qym.mapper.PeopleMapper.sele",5);
		System.out.println(p2);
		return p2;
	}

}
