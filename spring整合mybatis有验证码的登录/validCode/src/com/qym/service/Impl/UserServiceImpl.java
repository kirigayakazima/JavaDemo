package com.qym.service.Impl;

import com.qym.mapper.UserMapper;
import com.qym.pojo.User;
import com.qym.service.UserService;

public class UserServiceImpl implements UserService{
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User login(User user) {
		System.out.println("��ʼ����selby������"+"   userΪ��"+user);
		User user1=userMapper.selByUserPwd(user);
		System.out.println("user1�ǣ�"+user1);
		return user1;
	}

}
