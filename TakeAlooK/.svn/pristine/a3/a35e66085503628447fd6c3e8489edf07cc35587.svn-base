package com.bit.tak.model.vo.host;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Hr_Img {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "img_no")
	private int imgNo;

	@ManyToOne
	@JoinColumn(name = "hr_no",nullable = false)
	private Host_Review hrNo;

	@Column(name = "hr_img")
	private int hrImg;


}