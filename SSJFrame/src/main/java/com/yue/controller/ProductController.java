package com.yue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//增加或修改的功能
//	@RequestMapping(value={"/add","/mod"})
//	public String addOrMod(HttpServletRequest request, Comp_vo comp_vo){
//		Computer comp = new Computer();
//		comp.setCode(comp_vo.getCode());
//		comp.setHost(comp_vo.getHost());
//		comp.setVision(comp_vo.getVision());
//		comp.setPrice(comp_vo.getPrice());
//		comp.setDate(comp_vo.getDate());
//		if (comp_vo.getId()==null) {
//			computerService.insert(comp);
//		}else{
//			comp.setId(comp_vo.getId());
//			computerService.Update(comp);
//		}
//		return "redirect:/admin/index";
//	}
//	增加数据验证功能
	@RequestMapping(value={"/add","/mod"})
	public String addOrMod(HttpServletRequest request,@Validated Comp_vo comp_vo,BindingResult result){
		String str ="";
		Computer comp = new Computer();
		if (result.hasErrors()) {
			List<ObjectError> list=result.getAllErrors();
			for (ObjectError objectError : list) {
				System.out.println(objectError);
			}
			request.setAttribute("list", list);
			str="/computer/error";
		}else {
			comp.setCode(comp_vo.getCode());
			comp.setHost(comp_vo.getHost());
			comp.setVision(comp_vo.getVision());
			comp.setPrice(comp_vo.getPrice());
			comp.setDate(comp_vo.getDate());
			if (comp_vo.getId()==null) {
				computerService.insert(comp);
			}else{
				comp.setId(comp_vo.getId());
				computerService.Update(comp);
			}
			str= "redirect:/admin/index";
		}
		return str;
	}
	
	//获取单个商品的信息用做修改,然后返回到modUI页面
	@RequestMapping(value="/getone/{id}")
	public String getone(HttpServletRequest request,@PathVariable Long id) {
		Computer computer = computerService.getById(id);
		request.setAttribute("comp", computer);
		return "computer/modUI";
	}
	
	//查询所有
	@RequestMapping(value="getall")
	public ModelAndView getAll(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		List<Computer> list = computerService.getall();
		mv.addObject("list", list);
		mv.setViewName("admin/index");
		return mv;
	}
//	
//	//删除单个或多个商品,方式一：通过JPA提供的方法，通过id的list查询，返回实体的集合，调用批量删除方法
//	@RequestMapping(value="/del/{ids}")
//	public String del(HttpServletRequest request,@PathVariable("ids") String ids) {
//		String[] strs = ids.split(",");
//		List<Long> list = new ArrayList<>();
//		for (int i = 0; i < strs.length; i++) {
//			list.add(Long.parseLong(strs[i]));
//		}
//		//删除多个
//		computerService.deleteByLists(computerService.findByIds(list));
//		return "admin/index";
//	}
	//删除单个或多个商品。方式二：自定义SQL语句，占位符的值为id类型的集合
	@RequestMapping(value="/del/{ids}")
	public String del(HttpServletRequest request,@PathVariable("ids") String ids) {
		String[] strs = ids.split(",");
		List<Long> list = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			list.add(Long.parseLong(strs[i]));
		}
		//删除多个
		computerService.delMore(list);
//		return "admin/index";
		return "redirect:/admin/index";
	}
	
//	//删除单个或多个商品,方式三：迭代删除，会多次调用数据库删除
//	@RequestMapping(value="/del/{ids}")
//	public String del(HttpServletRequest request,@PathVariable("ids") String ids) {
//		String[] list = ids.split(",");
//		List<Long> list2 = new ArrayList<Long>();
//		for (int i = 0; i < list.length; i++) {
//			list2.add(Long.parseLong(list[i]));
//		}
//		System.out.println(list2);
//		if (list2.size()>1) {
//			for (int i = 0; i < list2.size(); i++) {
//				computerService.deleteById(list2.get(i));
//			}
//		}else {
//			Long id = list2.get(0);
//			computerService.deleteById(id);
//		}
//		return "admin/index";
//	}
}
