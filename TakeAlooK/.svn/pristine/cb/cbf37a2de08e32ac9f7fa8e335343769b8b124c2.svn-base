package com.bit.tak.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bit.tak.CommunityPredicate;
import com.bit.tak.model.repository.CcommentRepo;
import com.bit.tak.model.repository.CommunityRepo;
import com.bit.tak.model.repository.LikeRepo;
import com.bit.tak.model.vo.community.Ccomment;
import com.bit.tak.model.vo.community.CommLike;
import com.bit.tak.model.vo.community.Community;
import com.bit.tak.model.vo.community.Search;

@Repository
@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService {

	@Autowired
	CommunityRepo communityRepo;
	
	@Autowired
	CcommentRepo ccommentRepo;
	
	@Autowired
	LikeRepo likeRepo;
	/*
	 * @Override public Page<Community> commList(Pageable pageable, Search search) {
	 * //pageable = PageRequest.of(1, 5, Sort.Direction.DESC,"commNo");
	 * //List<Community> commList = communityRepo.findAllList();
	 * 
	 * //System.out.println(builder); return
	 * communityRepo.findAllList(pageable,CommunityPredicate.search(search)); }
	 */
	
	@Override
	public Page<Community> commList(Search search, Pageable pageable) {
		return communityRepo.findAll(CommunityPredicate.search(search), pageable);
	}
	
	@Override
	public Community commView(Community community) {
		return communityRepo.findById(community.getCommNo()).get();
	}

	@Override
	public void commWrite(Community community) {
		// TODO Auto-generated method stub

	}

	@Override
	public void commUpdate(Community community) {
		Community findList = communityRepo.findById(community.getCommNo()).get();
		findList.setCommTitle(community.getCommTitle());
		findList.setCommContents(community.getCommContents());
		communityRepo.save(findList);
		/*
		 * Community commUp = communityRepo.fi;
		 * commUp.setCommTitle(community.getCommTitle());
		 * commUp.setCommContents(community.getCommContents());
		 * communityRepo.save(commUp);
		 */
	}

	@Override //조회수
	public void contentView(Community community) {
		Community viewCount = communityRepo.findById(community.getCommNo()).get();
		viewCount.setCommHit(community.getCommHit()+1);
		communityRepo.save(viewCount);
	}
	
	//댓글
	@Override
	public List<Ccomment> commentLi(int commNo) {
		// TODO Auto-generated method stub
		return ccommentRepo.findByCommNo(commNo);
	}

	@Override
	public void commentWrite(Ccomment ccomment) {
		ccommentRepo.save(ccomment);
	}

	@Override
	public void commentUpdate(Ccomment ccomment) {
		Ccomment findComment = ccommentRepo.findById(ccomment.getCmentNo()).get();
		findComment.setCmentContents(ccomment.getCmentContents());
		ccommentRepo.save(findComment);
		
	}

	@Override
	public void commentDelete(int cmentNo) {
		
		
	}

	//좋아요
	
	@Override
	public void commLike(CommLike commLike) {
		/*
		 * Map<String, Object> m = new HashMap<>();
		 * 
		 * m.put("commNo", request.getParameter("commNo")); m.put("nickname",
		 * request.getParameter("nickname"));
		 */
		int commNo = commLike.getCommNo().getCommNo();
		String nickname = commLike.getNickname().getNickname();
		System.out.println("before result");
		int result = likeRepo.likeCheck(commNo, nickname);
		System.out.println("result:" + result);
		if(result == 0) {
			likeRepo.save(commLike);
		}else {
			likeRepo.likeDelete(commNo, nickname);
		}
	}
	
	@Override
	public int likeCount(CommLike commLike, Community community) {
		int no = commLike.getCommNo().getCommNo();
		int count = likeRepo.likeCount(no);
		Community likeCnt = communityRepo.findById(community.getCommNo()).get();
		likeCnt.setCommLike(count);
		communityRepo.save(likeCnt);
		System.out.println("count:" + count);
		return count;
	}

}
