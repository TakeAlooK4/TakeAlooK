package com.bit.tak.model.vo.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Company {
	
	@Id 
	@Column(name = "c_no")
	private String cNo;	// 기업 아이디(사업자 번호)
	
	@Column(name = "c_password")
	private String cPassword;
	
	@Column(name = "c_name", unique = true)
	private String cName;
	
	@Column(name = "c_address")
	private String cAddress;
	
	@Column(name = "c_phone")
	private String cPhone;
	
	@Column(name = "c_manager")
	private String cManager;
	
	
	
}
