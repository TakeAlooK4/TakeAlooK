
package com.bit.tak.model.vo.product;

import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.bit.tak.model.vo.member.Company;
import com.bit.tak.model.vo.productCode.P_Age;
import com.bit.tak.model.vo.productCode.P_Code;
import com.bit.tak.model.vo.productCode.P_Fp;
import com.bit.tak.model.vo.productCode.P_Mrm;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pr_no")
	private int prNo;
	
	//상품코드
	@ManyToOne
	@JoinColumn(name = "p_code")	
	private P_Code pCode;
	
	//연령코드
	@ManyToOne
	@JoinColumn(name = "age_code")
	private P_Age ageCode;
	
	//주재료 코드
	@Nullable
	@ManyToOne
	@JoinColumn(name = "mrm_code")
	private P_Mrm mrmCode;
	
	//상품타입
	@Nullable
	@ManyToOne
	@JoinColumn(name = "fp_code")
	private P_Fp fpCode;
	
	@Column(name = "animal_type")
	private String animalType;
	
	@Column(name = "pr_Name")
	private String prName;
	
	@Column(name = "pr_Cost")
	private int prCost;
	
	@Column(name = "pr_amount")
	private int prAmount;
	
	@Column(name = "main_img01")
	private String mainImg01;

	@Column(name = "detail_img01")
	private String detailImg01;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "c_no")
	private Company cNo;
}