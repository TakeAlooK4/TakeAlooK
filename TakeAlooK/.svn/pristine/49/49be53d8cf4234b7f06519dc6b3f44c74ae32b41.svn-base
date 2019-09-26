package com.bit.tak.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bit.tak.model.repository.CommunityRepo;
import com.bit.tak.model.service.CommunityService;
import com.bit.tak.model.vo.community.Community;
import com.bit.tak.model.vo.member.Muser;

@Controller
public class MyPageController {

	@Autowired
	CommunityService communityService;
	
	@Autowired
	CommunityRepo communityRepo;
	
	
	@RequestMapping("mw")
	public String myCommunity(Community community, HttpSession session, Model model) {
		Muser muser = (Muser)session.getAttribute("muser");
		String nickname = muser.getNickname();
		List<Community> myComm = communityRepo.findByNickname(nickname);
		model.addAttribute("content", myComm);
		//System.out.println("mw : " + muser);
		return "myPage/myWrite";
	}
	
	@ResponseBody
	@RequestMapping("md")
	public void myContentDelete(@RequestParam("commNo")List<Integer> commNo) {
		System.out.println("commNo :" + commNo);
		for(int aa : commNo) {
			System.out.println(aa);
			communityRepo.deleteMyContent(aa);
		}
	}
	
	@ResponseBody
	@RequestMapping("ml")
	public void myContentList(@RequestParam("nickname")Community community, HttpSession session) {
		Muser muser = (Muser)session.getAttribute("muser");
		String nickname = muser.getNickname();
		communityRepo.findByNickname(nickname);
	}
}
