package com.qym.mapper;

import org.apache.ibatis.annotations.Select;

import com.qym.pojo.User;

public interface UserMapper {
	@Select("select * from user where username=#{username} and password=#{password}")
	User selByUserPwd(User user);
}