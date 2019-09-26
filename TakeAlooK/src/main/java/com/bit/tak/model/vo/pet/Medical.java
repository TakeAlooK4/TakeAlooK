package com.bit.tak.model.vo.pet;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.bit.tak.model.vo.clinic.Tclinic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Medical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medical_no")
	private int medicalNo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_id")
	private Pet petId;

	@OneToOne()
	@JoinColumn(name = "t_code")
	private Tclinic tCode;
	
	@Column(name = "clinic_hos")
	private String clinicHos;

	@Column(name = "medical_date")
	private Date medicalDate;

	@Column(name = "medical_cost")
	private int medicalCost;

	@Column(name = "medical_memo")
	private String medicalMemo;
}
