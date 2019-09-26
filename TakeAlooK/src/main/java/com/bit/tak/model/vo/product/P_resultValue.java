package com.bit.tak.model.vo.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class P_resultValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "result_value")
	private int resultValue;
	
	@OneToOne
	@JoinColumn(name = "cartNo")
	private Cart cart;
	
	@Column(name="sum_value")
	private int sumValue;
	
}