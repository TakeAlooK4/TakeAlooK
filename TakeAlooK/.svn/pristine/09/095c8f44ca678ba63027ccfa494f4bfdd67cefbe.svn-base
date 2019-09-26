package com.bit.tak.model.vo.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.bit.tak.model.vo.clinic.Tclinic;
import com.bit.tak.model.vo.productCode.Area;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Hospital {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hos_no")
	private String hosNo;

	
	@Column(name = "pet_code")
	private String petCode;
		
	
	@Column(name = "c_name")
	private String cName;
	
	@ManyToOne
	@JoinColumn(name = "t_code")
	private Tclinic tCode;
		
	@Column(name = "hos_cost")
	private int hosCost;
	
	@ManyToOne
	@JoinColumn(name = "area_code")
	private Area areaCode;
	
	
	@Column(name = "pet_gender")
	private String petGender;
	
	@Column(name = "main_img01")
	private String mainImg01;
	
	@Column(name = "main_img02")
	private String mainImg02;
	
	@Column(name = "main_img03")
	private String mainImg03;
	
	@Column(name = "detail_img01")
	private String detailImg01;
}