 package com.bjsxt.service.Impl;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.dao.Impl.LoginDaoImpl;
import com.bjsxt.pojo.User;
import com.bjsxt.service.MethodService;

public class MethodServiceImpl implements MethodService {
	
	LoginDao ld=new LoginDaoImpl();
	@Override
	public User checkloginservice(String uname, String pwd) {
		return ld.checklogindao(uname, pwd);
	}
}
