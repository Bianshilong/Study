package com.bsl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsl.dao.UserDao;
import com.bsl.entity.User;
import com.bsl.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Override			//添加用户
	public Long add(User user) {
		Long id = dao.save(user);
		return id;
	}

	@Override			//更新用户
	public void update(User user) {
		dao.update(user);
	}

	@Override			//删除用户
	public void delete(User user) {
		dao.delete(user);
	}

//	@Override			//通过用户名和密码来查找用户，主要用来验证登录
//	public List<User> getByNameAndPass(User user) {
//		List<User> list = dao.findByNameAndPass(user);
//		return list;
//	}

	@Override			//查询所有用户，可以不重写
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	//判断是否登录
	public boolean validLogin(User user) {
		return dao.findByNameAndPass(user).size()>0;
	}
}
