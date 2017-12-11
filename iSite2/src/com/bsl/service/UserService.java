package com.bsl.service;

import java.util.List;

import com.bsl.entity.User;

public interface UserService {
	
	//服务层，添加用户
	Long add(User user);
	
	//更新用户
	void update(User user);
	
	//删除用户
	void delete(User user);

	//通过用户名和密码来查找用户，主要用来验证登录
	//List<User> getByNameAndPass(User user);
	
	//查询所有用户，可以不重写
	List<User> selectAll();
	
	boolean validLogin(User user);
}
