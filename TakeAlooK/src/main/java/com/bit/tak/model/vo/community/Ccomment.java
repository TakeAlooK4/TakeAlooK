package com.bit.tak.model.vo.community;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;

import com.bit.tak.model.vo.member.Muser;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table(name = "c_comment")
@DynamicInsert
public class Ccomment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cment_no")
	private Integer cmentNo;
	
	@ManyToOne
	@JoinColumn(name = "comm_no")
	private Community commNo;
	
	@ManyToOne
	@JoinColumn(name = "nickname")
	private Muser nickname;
	
	@Column(name = "cment_contents")
	private String cmentContents;
	
	
	@Column(name = "cment_date")
	private Date cmentDate;
}
