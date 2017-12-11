package com.bsl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bsl.dao.UserDao;
import com.bsl.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override		//根据用户名和密码查询
	public List<User> findByNameAndPass(User user) {
		List<User> list = find("select u from User u where u.username = ?0 and m.password=?1"
				,user.getUsername(),user.getPassword());
		return list;
	}

	@Override		//根据用户名查找
	public User findByName(String name) {
		List<User> list = find("select u from User u where u.username=?0",name);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
}
