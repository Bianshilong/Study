package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.entity.Computer;
import com.yue.repository.ComputerDao;

@Service
public class ComputerService {

	/**
	 * 查询所有电脑
	 * 通过id查询单个信息
	   新增信息
	   更新信息
	   删除信息
	 */
		
	@Autowired
	private ComputerDao dao;
	
	//通过id查询单个信息
	public Computer getById(Long id) {
		Computer comp = dao.getOne(id);
		return comp;
	}
	
	//查询所有
	public List<Computer> getall(){
		List<Computer> list = dao.findAll();
		return list;
	}
	//新增信息,更新信息,根据id获取到信息，现在在页面，然后修改信息后，调用该方法
	public void insertOrUpdate(Computer computer) {
		dao.save(computer);
	}
	
	//删除单个信息
	public void deleteById(Long id) {
		dao.delete(id);
	}
	
	/**
	 * 删除多个信息,可以通过前端传递的id切割成数组，
	 * 转换成整形数组，通过遍历查询所有的id对应的字段加入到list中，然后调用该方法删除
	 */
	public void delete(List<Computer> lsit) {
		dao.delete(lsit);
	}
	
	/**
	 * 或者在dao层使用@Query来定义查询多个ids和删除ids的方法来实现
	 */
}
