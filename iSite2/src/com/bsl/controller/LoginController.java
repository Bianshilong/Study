package com.bsl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bsl.entity.User;
import com.bsl.service.UserService;
import com.bsl.vo.Vo_user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Controller
public class LoginController {

	 @Autowired
	private UserService userService;
	// 验证用户登录的方法
	@RequestMapping(value = "/login")
	public String login(Vo_user vr) {
		User user = new User(vr.getName(),vr.getPass());
		String str=null;
		if (userService.validLogin(user)) {
			str="success";
		}
		return str;
	}
	
	//用户注册页面，注册成功后，显示信息
	@RequestMapping(value="/register")
	public String register(Vo_user vr) {
		User user = new User(vr.getName(),vr.getPass(),vr.getEmail(),vr.getSex(),vr.getBirth());
		userService.add(user);
		return "";
	}
}
