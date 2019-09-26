package com.bit.tak.model.vo.host;
import java.sql.Time;
import java.sql.Timestamp;
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
public class Host {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "host_no")
	private int hostNo;
	
	@ManyToOne
	@JoinColumn(name = "nickname", nullable = false)
	private Muser nickname;
	
	//제목
	@Column(name = "host_title")
	private String hostTitle;
	
	//모집일
	@Column(name = "host_recruit")
	private Date hostRecruit;
	
	//마감일
	@Column(name = "host_deadline")
	private Date hostDeadline;
	
	//모임시작
	@Column(name = "host_startdate")
	private Date hostStartdate;
	
	//모임마감
	@Column(name = "host_arrivaldate")
	private Date hostArrivaldate;
	
	//시작시간
	@Column(name = "host_starttime")
	private Time hostStarttime;
	
	//끝시간
	@Column(name = "host_arrivaltime")
	private Time hostArrivaltime;
	
	//참여자-->새로 테이블 만들어야될듯
	@Column(name = "host_participant")
	private int hostParticipant;
	
	//총 참가자
	@Column(name = "host_totalparticipant")
	private int hostTotalparticipant;
	
	//장소
	@Column(name = "host_place")
	private String hostPlace;
	
	//내용
	@Column(name = "host_contents")
	private String hostContents;
	
	//사진
	@Column(name = "host_img")
	private String hostImg;
	
	//별점--얘도 따로 만들어야될듯
	@Column(name = "host_gpa")
	private int hostGpa;
	
	//작성시간
	//@Temporal(TemporalType.TIMESTAMP.)
	@Column(name = "host_date")
	private Timestamp hostDate;
	
	//조회수
	@Column(name = "host_hit")
	private int hostHit;
	
	//승인여부
	@Column(name = "host_manager")
	private boolean hostManager;
	
	
}