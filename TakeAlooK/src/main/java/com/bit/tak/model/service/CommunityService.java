package com.bit.tak.model.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bit.tak.model.vo.community.Ccomment;
import com.bit.tak.model.vo.community.CommLike;
import com.bit.tak.model.vo.community.Community;
import com.bit.tak.model.vo.community.Search;
import com.bit.tak.model.vo.member.Muser;
import com.querydsl.core.BooleanBuilder;

public interface CommunityService {
	
	//Page<Community> commList(Pageable pageable, Search search);
	Page<Community> commList(Search search, Pageable pageable);

	Community commView(Community community);
	
	void commWrite(Community community);
	
	void commUpdate(Community community);
	
	void contentView(Community community);
	
	//댓글
	
	List<Ccomment> commentLi(int commNo);
	
	void commentWrite(Ccomment ccomment);
	
	void commentUpdate(Ccomment ccomment);
	
	void commentDelete(int cmentNo);
	
	//좋아요

	void commLike(CommLike commLike);
	
	int likeCount(CommLike commLike, Community community);
}
