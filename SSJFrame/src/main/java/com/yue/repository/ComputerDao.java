package com.yue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yue.entity.Computer;

public interface ComputerDao extends JpaRepository<Computer, Long>{
	
	//根据ids查询用户
//	@Query(value="select c from Computer c where c.id in (ids)")
//	List<Computer> findByIds(@Param("ids") String ids);
}
