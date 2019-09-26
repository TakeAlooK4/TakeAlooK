package com.bit.tak.model.vo.member;

import java.util.Date;

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
public class U_Report {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reportNo;
	
	@ManyToOne
	@JoinColumn(name = "reportee", referencedColumnName = "nickname")
	private Muser reportee;
	
	@ManyToOne
	@JoinColumn(name = "reporter", referencedColumnName = "nickname")
	private Muser reporter;
	
	private Date reportDate;
	
	private String reportBoard;
	
	private int reportBoardno;
	
	private int reportMentno;
	
	private Date handlingDate;
	
	@ManyToOne
	@JoinColumn(name = "handling_code")
	private Handling handlingCode;
	
	@ManyToOne
	@JoinColumn(name = "report_code")
	private Report reportCode;
	
}