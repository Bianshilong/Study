package com.yue.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.entity.Computer;
import com.yue.repository.ComputerDao;

@Service
@Transactional
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
	public void insert(Computer computer) {
		dao.save(computer);
	}
	
	//,更新信息,根据id获取到信息，显示在页面，然后修改信息后，调用该方法
	public void Update(Computer computer) {
		dao.save(computer);
	}
	
	//删除单个信息
	public void deleteById(Long id) {
		dao.delete(id);
	}
	
	/**
	 * 删除多个信息,可以通过前端传递的id切割成数组，
	 * 转换成整形数组，通过遍历查询所有的id对应的字段加入到list中，然后调用该方法删除
	 * 该方法未被调用
	 */
	public void delete(List<Computer> lsit) {
		dao.delete(lsit);
	}
	
	/**
	 * deleteByIds，方法二的删除方式
	 */
	public void delMore(List<Long> ids) {
		dao.deleteByIds(ids);
	}
	
	//通过id的集合来查询指定id的数据
	public List<Computer> findByIds(List<Long> ids){
		List<Computer> list = dao.findAll(ids);
		return list;
	}
	
	//批量删除,方法一的删除方式
	public void deleteByLists(List<Computer> list) {
		dao.deleteInBatch(list);
	}
}
