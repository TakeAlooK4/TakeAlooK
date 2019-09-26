package com.bit.tak.model.vo.pet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.bit.tak.model.vo.clinic.Tclinic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Life_Cycle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "life_cycle_no")
	private int lifeCycleNo;

	@OneToOne
	@JoinColumn(name = "t_code")
	private Tclinic tCode;
	
	@Column(name = "clinic_moment")
	private String clinicMoment;
	
	@Column(name = "clinic_date")
	private int clinicDate;
	
	
}
