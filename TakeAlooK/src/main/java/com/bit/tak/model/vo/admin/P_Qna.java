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
import com.bit.tak.model.vo.product.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class P_Qna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "q_no")
	private int pQno;
	
	@ManyToOne
	@JoinColumn(name = "nickname")
	private Muser user;
	
	@ManyToOne
	@JoinColumn(name = "pr_no")
	private Product product;
	
	@Column(name = "q_comment")
	private String pQcomment;
	
	@Column(name = "q_date")
	private Date pQdate;

}
