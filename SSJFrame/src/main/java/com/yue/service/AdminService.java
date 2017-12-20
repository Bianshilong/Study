package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.entity.Admin;
import com.yue.repository.AdminDao;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	//保存管理员信息到数据库
	public void insert(Admin admin) {
		adminDao.save(admin);
	}
	
	//通过用户名和密码查询管理员信息
	public List<Admin> findByNameAndPass(String username,String password) {
		List<Admin> list = adminDao.findByUsernameAndPassword(username, password);
		return list;
	}
	
	//验证用户名和密码是否存在
	public boolean checkLogin(Admin admin) {
		boolean flag = false;
		List<Admin> list = adminDao.findByUsernameAndPassword(admin.getUsername(), admin.getPassword());
		if (list.size()>0) {
			flag = true;
		}
		return flag;
	}
}
