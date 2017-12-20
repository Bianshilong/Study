package com.yue.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yue.service.ComputerService;

@Controller
@RequestMapping(value="/product")
public class ComputerController {
	
	@Autowired
	private ComputerService computerService;
	
	public ModelAndView findall(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
}
