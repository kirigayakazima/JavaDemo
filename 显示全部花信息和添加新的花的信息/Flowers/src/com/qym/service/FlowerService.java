package com.qym.service;

import java.util.List;

import com.qym.pojo.Flowers;

public interface FlowerService {
	//�����߼���ķ������������ݷ��ʲ��seleAll��������ʾ���еĻ���
	public List<Flowers> showAll();
	//���������ӻ���ķ���
	public Flowers addFlower(Flowers flower);
}
