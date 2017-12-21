package com.bsl.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Comp_vo {

	/**
	 * 编号：id   Long型
	   型号：Code	String 类型
	   主机：Host 		String类型
	   显示器：Vision		String类型
	   价格：price		double类型
	   生产日期：date		String类型
	 */
	
	private Long id;
	
	@NotEmpty(message="型号不能为空")
	private String code;
	
	@NotEmpty(message="主机不能为空")
	private String host;
	
	@NotEmpty(message="显示器不能为空")
	private String vision;
	
	@NotNull(message="价格不能为空")
	private Double price;
	
	private String date;
}
