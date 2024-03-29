package com.bit.tak.model.vo.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Sclinic {
	@Id
	@Column(name="s_code")
	private String sCode;

	@OneToOne
	@JoinColumn(name="f_code") 
	private Fclinic fCode;

	@Column(name="s_name")
	private String sName;
}
