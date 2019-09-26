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
public class P_Age {

	@Id
	private String ageCode;
	
	private String ageName;
}
