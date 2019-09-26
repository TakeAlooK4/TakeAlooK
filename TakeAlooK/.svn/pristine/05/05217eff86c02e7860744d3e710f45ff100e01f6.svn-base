package com.bit.tak.model.vo.admin;

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
public class P_Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_no")
	private int pAnswerno;
	
	@ManyToOne
	@JoinColumn(name = "q_no")
	private P_Qna pQno;
	
	private String answerContent;
	
	@Column(name = "answer_date")
	private Date pAnswerDate;
}
