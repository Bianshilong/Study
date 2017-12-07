package com.bsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bsl.entity.User;
import com.bsl.form.Vo;
import com.bsl.service.UserService;

import lombok.Getter;
import lombok.Setter;

@Controller
@Getter@Setter
public class LoginAndRegistController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register")
	public String register(Vo vo) {
		User user = new User();
		user.setName(vo.getName());
		user.setPass(vo.getPass());
		userService.add(user);
		return "registerSuccess";
	}
	
	@RequestMapping("/login")
	public String login(Vo vo) {
		User user = new User(vo.getName(),vo.getPass());
		boolean check = userService.checklogin(user);
		String string =null;
		if (check) {
			string="loginSuccess";
		}
		return string;
	}
}
