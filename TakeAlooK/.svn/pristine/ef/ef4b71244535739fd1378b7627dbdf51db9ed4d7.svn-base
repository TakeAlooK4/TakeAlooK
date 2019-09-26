package com.bit.tak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bit.tak.model.repository.CompanyRepo;
import com.bit.tak.model.security.UserSha256;
import com.bit.tak.model.service.MemberService;
import com.bit.tak.model.vo.member.Company;
/***
 * 
 * @author 박태영
 *
 */

@SessionAttributes("company")
@Controller
public class CompanyMemberController {
	
	@Autowired
	CompanyRepo companyRepo;
	
	@Autowired
	MemberService memberService;
	
		// 기업 회원 로그인(뷰)
		@RequestMapping("/companyLogin")
		public String companyLogin() {
			return "member/companyLogin";
		}
		
		// 기업 유저 로그인 시 보내지는 곳
		@PostMapping("/companyLogin.do")
		public String companyLoginDo(Company company, Model model, @RequestParam("cNo")String cNo, @RequestParam("cPassword")String cPassword) {
			System.out.println("company     :   " + company);
			System.out.println("cNo      :    " + cNo);
			System.out.println("cPassword      :   " + cPassword);
			
			Company findCompany = companyRepo.findByCompany(company.getCNo(), UserSha256.encrypt(company.getCPassword()));
			
			if(findCompany != null) {
				model.addAttribute("company", findCompany);
				System.out.println("2     :     " + findCompany.getCPassword());
				return "redirect:/";
			} else {
				System.out.println("3       :        "  + findCompany);
				model.addAttribute("msg" , "아이디와 비밀번호가 맞지 않습니다.");
				return "member/companyLogin";
			}
		}
		
		// 로그아웃 시키는 메소드
		@RequestMapping("/companyLogOut")
		public String logOut(SessionStatus status) {
			status.setComplete();
			return "redirect:/";
		}
		
		// 기업 유저 회원가입(뷰)
		@RequestMapping("/companySignUp")
		public String companySignUp() {
			return "member/companySignUp";
		}
		
		// Ajax로 기업 idCheck 하는 구간
				@RequestMapping("/cidCheck")
				@ResponseBody
				public String cidCheck(String cNo) {
					System.out.println("cNo    :   " + cNo);
					Company company = companyRepo.findCNo(cNo);
					System.out.println("company    :   " + company);
					if (company != null) {
						return "사용중인 사업자번호 입니다.";
					} else {
						return "";
					}
				}
				
				// Ajax로 기업 cPhoneCheck 하는 구간
				@RequestMapping("/cPhoneCheck")
				@ResponseBody
				public String cPhoneCheck(String cPhone) {
					System.out.println("cPhone     :   " + cPhone);
					Company company = companyRepo.findCPhone(cPhone);
					System.out.println("company     :   " + company);
					if(company != null) {
						return "사용중인 번호 입니다.";
					} else {
						return "";
					}
				}
		
		// 기업 유저 회원가입시 보내지는 곳
		@RequestMapping("/companySignUp.do")
		public String companySignUpDo(Company company) {
			
			// 암호 확인 
			System.out.println("첫번째 : " + company.getCPassword());
						
			// 비밀번호 암호화 (sha256)
			String encryPassword = UserSha256.encrypt(company.getCPassword());
			company.setCPassword(encryPassword);
			System.out.println("두번째 : " + company.getCPassword());
						
			// 기업 회원가입 메소드
			memberService.companySignUp(company);
			
			return "redirect:companyLogin";
		}
		
		// 기업유저 아이디 찾기 (view) companySearchId
				@RequestMapping("/companySearchId")
				public String companySearchId() {
					return "member/companySearchId";
				}
				
				// 기업아이디 찾기 성공 companySearchSuc
				@RequestMapping("companySearchSuc")
				public String companySearchSuc(Company company, Model model) {
					System.out.println("company   :  " + company.getCName() + company.getCPhone());
					String searchCompanyNo = companyRepo.searchCompanyNo(company.getCName(), company.getCPhone());
					System.out.println("searchCompanyNo     :   " + searchCompanyNo);
					
					if(searchCompanyNo != null) {
						model.addAttribute("searchCompanyNo", searchCompanyNo);
						return "member/companySearchSuc";
					} else {
						model.addAttribute("msg", "가입된 정보가 없습니다.");
						return "member/companySearchId";
					}
				}
				
				// 기업유저 비밀번호 찾기 (view) companySearchPw
				@RequestMapping("/companySearchPw")
				public String companySearchPw() {
					return "member/companySearchPw";
				}
				
				// 비밀번호 찾기 성공
		
		
}
