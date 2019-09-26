package com.bit.tak.model.vo.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bit.tak.model.vo.member.Muser;
import com.bit.tak.model.vo.product.Hospital;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class H_Qna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "q_no")
	private int hQno;
	
	@ManyToOne
	@JoinColumn(name = "nickname")
	private Muser nickname;
	
	@ManyToOne
	@JoinColumn(name = "hos_no")
	private Hospital hosNo;
	
	@Column(name = "q_comment")
	private String hQcomment;
	
	@Column(name = "q_date")
	private Date hQdate;
}
