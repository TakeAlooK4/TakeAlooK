package com.bit.tak.model.vo.dictionary;

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
public class Dictionary {

	@Id
	@Column(name = "dic_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dicNo;
	
	@ManyToOne
	@JoinColumn(name = "s_initials")
	private Subheading dicSubcode;
	
	@Column(name = "dic_img")
	private String dicImg;
	
	@Column(name = "dic_video")
	private String dicVideo;
	
	@Column(name = "dic_title")
	private String dicTitle;
	
	@Column(name = "dic_contents")
	private String dicContents;
	
	@Column(name = "dic_date")
	private Date dicDate;
	
	@Column(name = "dic_likes")
	private int dicLikes;
}
