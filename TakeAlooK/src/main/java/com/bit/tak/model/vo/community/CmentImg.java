package com.bit.tak.model.vo.community;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class CmentImg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "img_no")
	private int imgNo;
	
	@ManyToOne
	@JoinColumn(name = "cmentNo", nullable = false)
	private Ccomment cmentNo;
	
	@Column(name = "cment_img")
	private String cmentImg;
}
