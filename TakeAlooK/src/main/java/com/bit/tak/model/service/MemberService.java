package com.bit.tak.model.service;

import com.bit.tak.model.vo.member.Company;
import com.bit.tak.model.vo.member.Muser;

//jinseon
public interface MemberService {
	
	void memberSignUp(Muser mUser);	// 회원가입 시켜주는 것
	
	void companySignUp(Company company);	// 기업회원가입 시켜주는 것
	
	Muser getMember(String user);
}
