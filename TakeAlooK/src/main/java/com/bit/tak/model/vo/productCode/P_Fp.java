package com.bit.tak.model.vo.productCode;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class P_Fp {

	@Id
	private String fpCode;
	
	private String fpName;
}