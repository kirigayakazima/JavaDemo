package com.qym.dao;

import java.util.List;

import com.qym.pojo.Flowers;

public interface FlowerDao {
	//���ݷ��ʲ�ӿڣ�������ʾ���л��ķ�����Ӧ����list����
	public List<Flowers> seleAll();
	//����һ����ӻ��ķ�����ʹ����ͨ��Flowers�෽������
	public Flowers insertFlower(Flowers flower);
}
