package com.yue.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bsl.vo.Comp_vo;
import com.yue.entity.Computer;
import com.yue.service.ComputerService;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	private ComputerService computerService;
	
	//获取新增页面，若用户名存在，则跳转到新增页面
	@RequestMapping(value="/addUI")
	public String getAdd(HttpSession session ){
		String str = "";
		
		if (null==session.getAttribute("admin")) {
			str= "admin/login";
		}else {
			str="computer/addUI";
		}
		return str;
	}
	
	@RequestMapping(value={"/add","/mod"})
	public String addOrMod(HttpServletRequest request,Comp_vo comp_vo){
//		String str = "";
		Computer comp = new Computer();
		comp.setCode(comp_vo.getCode());
		comp.setHost(comp_vo.getHost());
		comp.setVision(comp_vo.getVision());
		comp.setPrice(comp_vo.getPrice());
		comp.setDate(comp_vo.getDate());
		if (comp_vo.getId()==null) {
			computerService.insertOrUpdate(comp);
		}else{
			comp.setId(comp_vo.getId());
			computerService.insertOrUpdate(comp);
		}
		return "admin/index";
	}
	
}
