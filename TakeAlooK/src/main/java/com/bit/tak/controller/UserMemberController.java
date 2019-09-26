package com.bit.tak.controller;

import java.io.IOException;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.bit.tak.model.repository.MemberRepo;
import com.bit.tak.model.security.UserSha256;
import com.bit.tak.model.service.MemberService;
import com.bit.tak.model.vo.member.Muser;

@SessionAttributes("muser")
@Controller
public class UserMemberController {
	
	
	@Autowired
	MemberRepo memberRepository;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// naverLoginBo 사용
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	// 유저 회원 로그인(뷰)
	@RequestMapping("/memberLogin")
	public String memberLogin(HttpSession session, Model model) {
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);	// session 을 naverUrl 변수에 넣어둔다.
		model.addAttribute("url", naverAuthUrl);
		return "member/memberLogin";
	}
	
	
	// 일반 유저 로그인 시 보내지는 곳
	@PostMapping("/memberLogin.Do")
	public String memberLoginDo(Muser mUser, Model model, @RequestParam("id")String id, @RequestParam("password")String password, HttpSession session) {
		
		//TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
		Muser findUser = memberRepository.findByUser(mUser.getId(), UserSha256.encrypt(mUser.getPassword()));
	
		if(findUser != null) {
			model.addAttribute("muser", findUser);

			//session
			//session.setAttribute("muser",findUser);
			return "redirect:/";
		} else {
			
			model.addAttribute("msg" , "아이디와 비밀번호가 맞지 않습니다.");
			return "member/memberLogin";
		}
		
	}
	
//	네이버 로그인 callback	
	@RequestMapping(value = "/callback", method = {RequestMethod.GET, RequestMethod.POST})
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session, Muser mUser) throws IOException, ParseException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		
		// 1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);	// String 형식의 json 데이터
		
		
		// 2. String 형식인 apiResult를 json 형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;

		// 3. 데이터 파싱
		// Top 레벨 단계 _Response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		
		// response 의 nickname 값 파싱
		String nickname = (String) response_obj.get("nickname");
		System.out.println(nickname);
		
		String id = (String) response_obj.get("id"); 
		System.out.println(id);
		
		
		// 파싱한 값 set 해주는 곳
		mUser.setNickname(nickname);
		mUser.setName(id);
		mUser.setId(id);
		
		if(memberRepository.findId(mUser.getId()) == null) {
			
		}
		
		// 4. 파싱 닉네임 세션으로 저장
		session.setAttribute("sessionId", nickname); // 세션 생성
		model.addAttribute("result", apiResult);
		
		
		
		return "redirect:/";
	}
	
	// 네이버 로그아웃 
	@RequestMapping(value = "/naverLogOut", method = { RequestMethod.GET, RequestMethod.POST})
	public String naverLogOut(HttpSession session) throws IOException {
		System.out.println("여기는 naverLogOut");;
		session.invalidate();
		return "redirect:/";
	}
	
	// 로그아웃 시키는 메소드
	@RequestMapping("/userLogOut")
	public String logOut(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	
	// 일반 유저 회원가입(뷰)
	@RequestMapping("/memberSignUp")
	public String memberSignUp() {
		return "member/memberSignUp";
	}
	
	// Ajax로 일반유저 회원가입 idCheck 하는 구간
		@RequestMapping("/idCheck")
		@ResponseBody
		public String idCheck(String id) {
			System.out.println("id     :   " + id);
			Muser mUser = memberRepository.findId(id);
			System.out.println("user      :     " +mUser);
			if(mUser != null) {
				return "사용중인 아이디입니다.";
			}else {
				return "";
			}
		}
		
		// Ajax 로 일반유저 회원가입 nicknameCheck 하는 구간
		@RequestMapping("/nicknameCheck")
		@ResponseBody
		public String nicknameCheck(String nickname) {
			System.out.println("nickname   :   " + nickname);
			Muser mUser = memberRepository.findNickname(nickname);
			System.out.println("user    :    " + mUser);
			if(mUser != null) {
				return "사용중인 닉네임입니다.";
			} else {
				return "";
			}
		}
		
		// Ajax로 일반유저 회원가입 contactCheck 하는 구간
		@RequestMapping("contactCheck")
		@ResponseBody
		public String contactCheck(String contact) {
			System.out.println("contact     :     " + contact);
			Muser mUser = memberRepository.findContact(contact);
			System.out.println("user      :    " + mUser);
			if(mUser != null) {
				return "사용중인 핸드폰 번호입니다.";
			} else {
				return "";
			}
		}
	
	// 일반유저 회원가입 시 보내지는 곳
	@RequestMapping("/memberSignUp.do")
	public String memberSignUpDo(Muser mUser) {
		
		// 암호 확인
		System.out.println("첫번째 : " + mUser.getPassword());
		
		// 비밀번호 암호화 (sha256)
		String encryPassword = UserSha256.encrypt(mUser.getPassword());
		mUser.setPassword(encryPassword);
		System.out.println("두번째 : " + mUser.getPassword());
		
		// 회원가입 메소드
		memberService.memberSignUp(mUser);
		
		return "redirect:memberLogin";
	}
	
	// 일반유저 아이디 찾기 (view)
		@RequestMapping("/memberSearchId")
		public String memberSearchId() {
			System.out.println("아이디 찾기 거쳐서 간다.");
			return "member/memberSearchId";
		}
		
		// 아이디 찾기 성공
		@RequestMapping("/memberSearchSuc")
		public String memberSearchIdSuc(Muser mUser, Model model) {
			System.out.println("mUser    :    "  + mUser.getName() + mUser.getContact());
			String searchUserId = memberRepository.searchId(mUser.getName(), mUser.getContact());
			System.out.println("searchUserId     :  " + searchUserId);
			
			if(searchUserId != null) {
				model.addAttribute("searchUserId", searchUserId);
			return "member/memberSearchSuc";
			} else {
				model.addAttribute("msg", "가입된 정보가 없습니다.");
				return "member/memberSearchId";
			}
		}

		
		// 일반유저 비밀번호 찾기 (view)
		@RequestMapping("/memberSearchPw")
		public String memberSearchPw() {
			System.out.println("비밀번호 찾기 거쳐서 간다.");
			return "member/memberSearchPw";
		}
		
		// 비밀번호 찾기 성공
		@RequestMapping("/memberSearchPwSuc")
		public String memberSearchPwSuc(Muser mUser, Model model) {
			System.out.println("mUser     :    " + mUser.getName() + mUser.getId());
			String searchUserPw = memberRepository.searchPw(mUser.getName(), mUser.getId());
			System.out.println("searchUserPw      :     " + searchUserPw);
			
			if(searchUserPw != null) {
				model.addAttribute("searchUserPw", searchUserPw);
				return "member/memberSearchPwSuc";
			} else {
				model.addAttribute("msg", "이름과 아이디 정보가 일치하지 않습니다.");
			} return "member/memberSearchPw";
		}
	
}
