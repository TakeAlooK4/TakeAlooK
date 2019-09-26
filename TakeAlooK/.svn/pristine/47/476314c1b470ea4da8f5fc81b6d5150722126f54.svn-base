package com.bit.tak.model.vo.community;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bit.tak.model.vo.member.Muser;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "comm_like")
public class CommLike {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "like_no")
	private int likeNo;
	
	@OneToOne
	@JoinColumn(name = "comm_no")
	private Community commNo;

	@OneToOne
	@JoinColumn(name = "nickname")
	private Muser nickname;
	
	 
}
