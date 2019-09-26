package com.bit.tak.model.vo.host;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bit.tak.model.vo.member.Muser;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Host_Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hr_no")
	private int hrNo;
	
	@ManyToOne
	@JoinColumn(name = "host_no",nullable = false)
	private Host hostNo;
	
	//?
	@ManyToOne
	@JoinColumn(name = "nickname", nullable = false)
	private Muser nickname;
	
	@Column(name = "hr_contents")
	private String hrContents;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "hr_date")
	private Date hrDate;
	
	@Column(name = "hr_gpa")
	private int hrGpa; 
}
