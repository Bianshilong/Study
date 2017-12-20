package com.yue.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bsl.vo.Admin_vo;
import com.yue.entity.Admin;
import com.yue.service.AdminService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/loginUI")
	public String getLogin() {
		return "/admin/loginUI";
	}
	
	@RequestMapping(value="/login")
	public String getLogin(Model model, @Valid Admin_vo admin_vo,BindingResult result,
			HttpServletRequest request,HttpSession session) {
		String string = "";
		Admin admin = new Admin(admin_vo.getUsername(), admin_vo.getPassword());
		//判断是否为空
		if (result.hasErrors()) {
			model.addAttribute("error", admin_vo);
			string= "admin/error";
		}else {
			if (adminService.checkLogin(admin)) {
				session.setAttribute("admin", admin_vo.getUsername());
				string= "admin/index";
			}else {
				request.setAttribute("error_msg", "您输入的用户名或密码错误！！");
				string= "admin/error";
			}
		}
		return string;
	}
}
