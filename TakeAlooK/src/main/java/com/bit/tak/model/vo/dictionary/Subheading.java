package com.bit.tak.model.vo.dictionary;

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
public class Subheading {
	@Id
	@Column(name = "s_initials")
	private String sInitials;
	
	@Column(name = "s_category")
	private String sCategory;
	
}
