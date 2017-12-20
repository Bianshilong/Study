package com.yue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="comp_info")
@Getter@Setter
public class Computer extends IdEntity {

	/**
	 * 编号：id   Long型
	   型号：Code	String 类型
	   主机：Host 		String类型
	   显示器：Vision		String类型
	   价格：price		double类型
	   生产日期：date		String类型
	 */
	@Column(nullable=false)
	private String code;
	
	@Column(nullable=false)
	private String host;
	
	@Column(nullable=false)
	private String vision;
	
	@Column(nullable=false)
	private Double price;
	
	@Column(nullable=false)
	private String date;
	
}
