package com.bit.tak.model.vo.community;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;

import com.bit.tak.model.vo.member.Muser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@DynamicInsert
public class Community {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comm_no")
	private Integer commNo;
	
	@ManyToOne
	@JoinColumn(name = "nickname", nullable = false)
	private Muser nickname;
	
	@Column(name = "comm_title")
	private String commTitle;
		
	@Column(name = "comm_contents")
	private String commContents;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "comm_date")
	private Timestamp commDate;
	
	@Column(name = "comm_hit")
	private int commHit;
	
	@Column(name = "comm_like")
	private int commLike;
}
