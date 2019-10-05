package com.bjsxt.dao;

import com.bjsxt.pojo.User;

public interface LoginDao {
	 User checklogindao(String uname,String pwd);
	 User checkuiddao(String uid);
}
