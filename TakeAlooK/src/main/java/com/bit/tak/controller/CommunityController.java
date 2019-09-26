package com.bit.tak.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bit.tak.model.repository.CcommentRepo;
import com.bit.tak.model.repository.CommunityRepo;
import com.bit.tak.model.repository.LikeRepo;
import com.bit.tak.model.repository.MemberRepo;
import com.bit.tak.model.service.CommunityService;
import com.bit.tak.model.service.MemberService;
import com.bit.tak.model.vo.community.Ccomment;
import com.bit.tak.model.vo.community.CommLike;
import com.bit.tak.model.vo.community.Community;
import com.bit.tak.model.vo.community.Search;
import com.bit.tak.model.vo.member.Muser;

@Controller
@RequestMapping("community")
public class CommunityController {
	
	@Value("${file.uploadPath}")
	String uploadFileDir;
	
	@Autowired
	private CommunityRepo communityRepo;
	
	@Autowired
	private CommunityService communityService;
	
	@Autowired
	private CcommentRepo ccommentRepo;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private LikeRepo likeRepo;
	@RequestMapping("cl") //게시글 리스트
	public String commList(Model model, Pageable pageable, Search search) {
		
		//pageable = PageRequest.of(curPage, 10, Sort.Direction.DESC,"commNo");
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
		pageable = PageRequest.of(page, 10, new Sort(Direction.DESC, "commNo"));
		System.out.println(page);
		
//		log.debug("총 element 수 : {}, 전체 page 수 : {}, 페이지에 표시할 element 수 : {}, 현재 페이지 index : {}, 현재 페이지의  element 수 : {}",
//				list.getTotalElements(), list.getTotalPages(), list.getSize(), list.getNumber(), list.getNumberOfElements());
		
		if (search.getSearchCondition() == null)
			search.setSearchCondition("TITLE");
		if (search.getSearchKeyword() == null)
			search.setSearchKeyword(""); 
		
		Page<Community> list = communityService.commList(search, pageable);
		
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(date.format(today));
		model.addAttribute("today", date.format(today));
		model.addAttribute("comm",list);
		
		return "community/commList";
	}
	//페이징
//	Pagination pagination = new  Pagination(listCnt, curPage);
//	int listCnt = communityRepo.BoardCnt();
//	model.addAttribute("cnt", listCnt);
//	model.addAttribute("pagination", pagination);
	
	@RequestMapping("cw") //글작성 페이지
	public String commWrite(Community community) {
		return "community/commWrite";
	}
	
	@RequestMapping("commRegister") //작성 버튼
	public String commRegister(Community community) {
		communityRepo.save(community);
		TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
		return "redirect:cv"+ "/" + community.getCommNo();
	}
	
	/*
	 * @RequestMapping("cv/{commNo}") public String commView(@PathVariable int
	 * commNo, Model model) { model.addAttribute("data",
	 * communityRepo.findById(commNo)); return "community/commView"; }
	 */
	@RequestMapping("cv/{commNo}") //글 상세보기
	public String commView(@PathVariable("commNo") Community community, Model model, Ccomment ccomment, HttpSession session) {
		model.addAttribute("data2", ccomment);
	//	System.out.println(ccomment); 
		communityService.contentView(community);
		model.addAttribute("data", communityService.commView(community));
		try {
			Muser muser = (Muser)session.getAttribute("muser");
			String nick = muser.getNickname();
			model.addAttribute("no",likeRepo.commNO(community.getCommNo(),nick));
			//System.err.println(likeRepo.commNO(community.getCommNo(),nick));
		} catch (NullPointerException e) {
			return "community/commView";
		}
		
		return "community/commView";
	}
	
	@PostMapping("cw/{commNo}") //글 수정
	public String commUpdate(@PathVariable("commNo") Community community, Model model) {
		model.addAttribute("comm", communityService.commView(community));
		return "community/commUpdate";
	}
	
	@RequestMapping("commUp") //글 수정 버튼
	public String commUp(Community community) {
		TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
		communityService.commUpdate(community);
		return "redirect:cv"+ "/" + community.getCommNo();
	}
	
	@RequestMapping("/{commNo}") //글 삭제
	public String commDelete(@PathVariable("commNo") Community community) {
		communityRepo.deleteById(community.getCommNo());
		return "redirect:cl";
	}
	
	@ResponseBody
	@RequestMapping("image") //썸머노트 이미지 업로드
	public String image(MultipartFile file, HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = response.getWriter();

		String realFolder = request.getSession().getServletContext().getRealPath("/resources/static/image/");
		
		System.out.println("리얼패스 :" + realFolder);
		UUID uuid = UUID.randomUUID();
		
		String org_filename = file.getOriginalFilename();
		String str_filename = uuid.toString() + org_filename;
		System.out.println("원본 파일명 : " + org_filename);
		System.out.println("저장할 파일명 : " + str_filename);
		
		String filepath = realFolder  + str_filename;
		String filepath2 = uploadFileDir + str_filename;
		System.out.println("파일경로 : " + filepath);
		
		
		File f = new File(filepath);
		File f2 = new File(filepath2);
		if (!f.exists()) {
			f.mkdirs();
		}
		System.out.println("리얼패스 결과:" + f.getAbsolutePath());
		System.out.println("properties path 결과: " + f2.getAbsolutePath());
		System.out.println("CanonicalPath 결과: " + f2.getCanonicalPath());
		System.out.println("getPath 결과 : " + f2.getPath());
		//FileCopyUtils.copy(file.getBytes(), f);
		file.transferTo(f);
		/*
		 * out.println("/resources/static/image/" + str_filename); out.close();
		 */
		return "/resources/static/image/" + str_filename;
	}
	
	@ResponseBody
	@RequestMapping("/ment") //댓글 리스트
	public List<Ccomment> mentList(@RequestParam(value = "num")Community community, Model model) {
		
		return communityService.commentLi(community.getCommNo());
	} 
	 
	@ResponseBody
	@RequestMapping("/insert") //댓글 등록
	public void mentInsert(@RequestParam Community commNo, Ccomment ccomment) {
		ccomment.setCommNo(commNo);
		ccommentRepo.save(ccomment);
	}
	
	@ResponseBody
	@RequestMapping("/update") //댓글 수정
	public void mentUpdate(Ccomment ccomment) {
		System.out.println(ccomment);
		communityService.commentUpdate(ccomment);
	}
	
	@ResponseBody
	@RequestMapping("/delete/{cmentNo}") //댓글 삭제
	public void memtDelete(@PathVariable("cmentNo") Ccomment ccomment) {
		ccommentRepo.deleteById(ccomment.getCmentNo());
	}
	
	//좋아요
	@ResponseBody
	@PostMapping("likeUpdate")
	public void commLike(CommLike commLike, Community community) {
		System.out.println("라이크 :" + commLike.getLikeNo());
		commLike.setCommNo(communityRepo.findById(commLike.getCommNo().getCommNo()).get());
		commLike.setNickname(memberRepo.findById(commLike.getNickname().getNickname()).get());		
		System.out.println("beforService");
		communityService.commLike(commLike);
	}
	
	@ResponseBody
	@RequestMapping("likeCount") // 좋아요 개수
	public int commLikeCount(CommLike commLike, Community community) {
		int count = communityService.likeCount(commLike, community);
		System.out.println(count);
		return count;
	}
	
	@RequestMapping("test")
	public String test() {
		return "/community/test";
	}
}