package com.bit.tak.model.vo.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class U_DelReason {
	@Id
	@Column(name = "u_delcode")
	private int uDelcode;
	
	@Column(name = "u_contents")
	private String uContents;
}
