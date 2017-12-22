package com.yue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yue.entity.Computer;

public interface ComputerDao extends JpaRepository<Computer, Long>{
	
	@Modifying
	@Query(value="delete from comp_info where id in (?1)",nativeQuery=true)
	void deleteByIds(List<Long> ids);
	//查询多个ids
	
}
