package com.bjsxt.service.Impl;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.Impl.UserDaoImpl;
import com.bjsxt.service.UserService;
import com.bjsxt.vo.User;

public class UserServiceImpl implements UserService{
	//获取dao层对象
	UserDao ud=new UserDaoImpl();
	@Override
	public User getUserInfoService(String name) {
		
		return ud.getUserInfo(name);
	}

}
