
package com.bit.tak.model.vo.admin;

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
import com.bit.tak.model.vo.product.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class P_Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_no")
	private int reviewNo;
		
	@ManyToOne
	@JoinColumn(name = "pr_no")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "nickname")
	private Muser user;
	
	@Column(name="review")
	private String review;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "review_date")
	private Date reviewDate;
}
//ssssss