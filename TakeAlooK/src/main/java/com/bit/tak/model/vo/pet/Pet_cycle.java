package com.bit.tak.model.vo.pet;

import java.io.Serializable;
import java.sql.Date;

import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bit.tak.model.vo.clinic.Tclinic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="pet_cycle")
public class Pet_cycle {//implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pet_cycle_no")
	private int petCycleNo;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "pet_id")
	private Pet petId;
	
	@ManyToOne
	@JoinColumn(name = "life_cycle_no")
	private Life_Cycle lifeCycleNo;

	
	@Column(name = "clinic_date")
	private Date clinicDate;

	@Nullable
	@Column(name = "clinic_check")
	private Date clinicCheck;
	
}
