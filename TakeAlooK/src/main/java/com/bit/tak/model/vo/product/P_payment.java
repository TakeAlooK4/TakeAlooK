package com.bit.tak.model.vo.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.bit.tak.model.vo.member.Muser;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class P_payment {


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="paymentno")
	private int paymentno;
	
	@ManyToOne
	@JoinColumn(name = "pr_no")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "nickname")
	private Muser muser;

	@Column(name="address")
	private String address;
	
	@Column(name="cellphone")
	private String cellphone;	
	
	@Column(name="sumvalue")
	private int sumvalue;
	
	

}
