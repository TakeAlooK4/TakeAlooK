package com.bit.tak.model.vo.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class U_Del {
	
	@Id
	@Column(name = "u_delno")
	private int uDelNo;
	
	@ManyToOne
	@JoinColumn(name = "nickname", nullable = false)
	private Muser nickname;
	
	@ManyToOne
	@JoinColumn(name = "u_delcode", nullable = false)
	private U_DelReason uDelcode;
}