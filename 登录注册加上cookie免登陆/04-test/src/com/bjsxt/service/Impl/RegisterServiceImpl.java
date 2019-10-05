package com.bjsxt.service.Impl;

import com.bjsxt.dao.RegisterDao;
import com.bjsxt.dao.Impl.RegisterDaoImpl;
import com.bjsxt.pojo.User;
import com.bjsxt.service.RegisterService;


public class RegisterServiceImpl implements RegisterService{
	RegisterDao rd=new RegisterDaoImpl();
	@Override
	public User checkregisterservice(String rname, String rpwd) {
		
		return	rd.checkregisterdao(rname, rpwd);
	}
}
