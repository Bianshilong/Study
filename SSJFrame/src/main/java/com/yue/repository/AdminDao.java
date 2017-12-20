package com.yue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yue.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
	
	List<Admin> findByUsernameAndPassword(String username,String password);
}
