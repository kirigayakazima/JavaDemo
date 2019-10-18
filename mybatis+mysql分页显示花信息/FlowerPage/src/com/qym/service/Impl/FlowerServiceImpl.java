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
		//��ȡ��Դ
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		//�õ���Դ����н����߹���ģʽ����
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		//����Դ
		SqlSession session=factory.openSession();
		//��ʼ������Դ����
		//����һ��map����
		//����һ���µ�pojo���󣬴洢��ҳ��Ϣ
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
