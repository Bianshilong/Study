package com.bsl.service;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsl.dao.UserDao;
import com.bsl.entity.User;

import lombok.Getter;
import lombok.Setter;

@Service
@Setter@Getter
public class UserService {

	@Autowired
	private UserDao dao;
	
	public void add(User user) {
		dao.insert(user);
	}
	
	public boolean checklogin(User user) {
		List<User> list = dao.byNameAndPass(user);
		boolean flag =false;
		if (list.size()>0) {
			flag=true;
		}
		return flag;
	}
}
