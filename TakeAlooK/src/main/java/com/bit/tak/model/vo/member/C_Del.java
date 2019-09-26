package com.bit.tak.model.vo.member;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class C_Del {
	
	@Id
	@Column(name = "c_delno")
	private int cDelNo;
	
	@ManyToOne
	@JoinColumn(name = "c_no")
	private Company cNo;
	
	@Column(name = "expiration_date")
	private Date expirationDate;
}
