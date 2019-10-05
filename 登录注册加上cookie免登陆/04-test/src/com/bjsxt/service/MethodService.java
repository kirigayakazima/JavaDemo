package com.bjsxt.service;

import com.bjsxt.pojo.User;

public interface MethodService {
	User checkloginservice(String uname,String pwd);
	User checkuidservice(String uid);
}
