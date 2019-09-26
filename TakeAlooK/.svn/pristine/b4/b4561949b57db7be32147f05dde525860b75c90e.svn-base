package com.bit.tak.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.tak.model.repository.CompanyRepo;
import com.bit.tak.model.repository.MemberRepo;
import com.bit.tak.model.vo.member.Company;
import com.bit.tak.model.vo.member.Muser;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private CompanyRepo companyRepository;
	
	@Autowired 
	private MemberRepo memberRepository;
	
	// 일반유저 회원가입 시켜주기
	@Override
	public void memberSignUp(Muser mUser) {
		memberRepository.save(mUser);
	}

	// 기업유저 회원가입 시켜주기
	@Override
	public void companySignUp(Company company) {
		companyRepository.save(company);
	}

	@Override
	public Muser getMember(String user) {
		// TODO Auto-generated method stub
		return memberRepository.findById(user).get(); 	//갖고와 이자슥아!
	}
	

}
