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
public class Tclinic {
	@Id
	@Column(name="t_code")
	private String tCode;

	@OneToOne
	@JoinColumn(name="s_code") 
	private Sclinic sCode;

	@Column(name="t_name")
	private String tName;
}
