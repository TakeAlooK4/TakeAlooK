package com.bit.tak.model.vo.host;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Host_Img {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "img_no")
	private int imgNo;
	
	@ManyToOne
	@JoinColumn(name = "host_no",nullable = false)
	private Host hostNo;
	
	@Column(name = "host_img")
	private String hostImg;
	
	
	
}