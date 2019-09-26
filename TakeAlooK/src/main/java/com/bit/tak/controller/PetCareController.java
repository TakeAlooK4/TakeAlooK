package com.bit.tak.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bit.tak.model.repository.BreedRepo;
import com.bit.tak.model.repository.Life_cycleRepo;
import com.bit.tak.model.repository.MedicalRepo;
import com.bit.tak.model.repository.PetRepo;
import com.bit.tak.model.repository.Pet_cycleRepo;
import com.bit.tak.model.repository.SclinicRepo;
import com.bit.tak.model.repository.TclinicRepo;
import com.bit.tak.model.service.MemberService;
import com.bit.tak.model.service.PetCareService;
import com.bit.tak.model.vo.clinic.Sclinic;
import com.bit.tak.model.vo.clinic.Tclinic;
import com.bit.tak.model.vo.member.Muser;
import com.bit.tak.model.vo.pet.Breed;
import com.bit.tak.model.vo.pet.Life_Cycle;
import com.bit.tak.model.vo.pet.Medical;
import com.bit.tak.model.vo.pet.Pet;
import com.bit.tak.model.vo.pet.Pet_cycle;

@SessionAttributes("muser")
@Controller
public class PetCareController {

	private static final Logger logger = LoggerFactory.getLogger(PetCareController.class);

	@Autowired
	MemberService memberService;
	@Autowired
	PetCareService petCareService;
	@Autowired
	PetRepo petRepo;
	@Autowired
	BreedRepo breedRepo;
	@Autowired
	SclinicRepo sclinicRepo;
	@Autowired
	TclinicRepo tclinicRepo;
	@Autowired
	MedicalRepo medicalRepo;
	@Autowired
	Life_cycleRepo life_cycleRepo;
	@Autowired
	Pet_cycleRepo pet_cycleRepo;

	Muser user;
	//String uploadPath;

	//@Value("${spring.resources.static-locations}")
	@Value("${file.uploadPath}")
	String uploadPath;
	@GetMapping("/header")
	public String s() {
		
		return "header";
	}


	//제일 처음 정보창--------------------------------------------------------------------------
	@GetMapping("/petCare")
	public String getPetCareList(Model model, HttpSession session) {
		
		 System.out.println("dddddddwgwgdsgwgewg : : "+org.springframework.core.SpringVersion.getVersion());
		//Muser muser =  (Muser) request.getSession();
		
		//유저정보
		user = (Muser) session.getAttribute("muser");
		System.out.println("slqk : "+user);
		model.addAttribute("user",user );

		//브리드 코드
		model.addAttribute("breed", petCareService.getBreedList());
		
		//클리닉
		model.addAttribute("fClinic", petCareService.getFclinic());
		model.addAttribute("sClinic", sclinicRepo.getSclinic("f1"));
		model.addAttribute("tClinic", tclinicRepo.getTclinic("s1"));

		//동물 정보ㅁ
		List<Pet> petInfo = petCareService.findByNickname(user);
		//List<Pet> petInfo = petCareService.findByNickname(user);=====

		//만 나이
		for ( Pet p : petInfo) { 
			p.setPetAge(getAge(p.getPetBirth()));

			petRepo.save(p);
		}

		model.addAttribute("pet",petInfo);

		
		
		//유저가 가지고 있는 값의 최소 펫아이디 => 첫번째 아이디 ㅇㅇ
		if(petRepo.existPetId(user)!=0) {
		int s = petRepo.minPetId(user);
		
		int minPetId = petRepo.minPetId(user);
		
		List<Medical> medical = petCareService.findByPetId(user,minPetId);

		model.addAttribute("medical",medical );
		int total=0;
		int count;
		for (count = 0; count < medical.size(); count++) {
			total += medical.get(count).getMedicalCost();
		}
		//의료기록 돈
		model.addAttribute("total",total);
		model.addAttribute("count",count);

		model.addAttribute("cycle", pet_cycleRepo.getCycle(minPetId));
		model.addAttribute("tCycle", pet_cycleRepo.getTCycle(minPetId));
		model.addAttribute("uCycle", pet_cycleRepo.getUCycle(minPetId));
		
		}	
		return "petCare/getPetCareList";
	}

	//만 나이 구하기
	private int getAge(Date birthDay) { 
		Calendar birth = new GregorianCalendar();
		Calendar today = new GregorianCalendar();

		birth.setTime(birthDay); 
		today.setTime(petRepo.curdate()); 
		int factor = 0;

		if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
			factor = -1; 
		} 
		return today.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + factor;
	}

	//각자의 의료기록 뽑아내기--------------+생애주기------------------------------------------------------------
	@ResponseBody
	@GetMapping("/petMedicalList")
	public List<Medical> getPetMedicalList(@RequestParam("petId")int petId){


		List<Medical> medical = petCareService.findByPetId(user,petId);
		if(medical.size()!=0) {

			return medical;
		}else {

			return null; 
		}
	}
	
	
	

	//생애주기+생애주기-----------------------------------------------------------------------
	@ResponseBody
	@GetMapping("/petCycleList")
	public List<Pet_cycle> petCycleList(@RequestParam("petId")int petId){

		return pet_cycleRepo.getTCycle(petId);
	}
	//생애주기+지난생애주기-----------------------------------------------------------------------
	@ResponseBody
	@GetMapping("/petUCycleList")
	public List<Pet_cycle> petUCycleList(@RequestParam("petId")int petId){
		
		return pet_cycleRepo.getUCycle(petId);
	}
	
	//생애주기+생애주기 1개만-----------------------------------------------------------------------
	@ResponseBody
	@GetMapping("/petCycle")
	public Pet_cycle petCycle(@RequestParam("petId")int petId){
		
		
		return pet_cycleRepo.getCycle(petId);
	}



	//petCode로 품종고르기
	@ResponseBody
	@GetMapping("/petCode")
	public List<Breed> petCode(Model model,@RequestParam(value="petCode")String petCode){
		List<Breed> selectPetCode =  breedRepo.findByBreedCodeStartingWith(petCode);
		
		return selectPetCode;
	}

	//정보등록
		@PostMapping("/petInsert")
		public String petInsert(Model model, Pet pet) {
			//강아지 저장
			petRepo.save(pet);

			petCareService.petCycleInsert(pet);

			return "redirect:/petCare";
		}



	public static java.sql.Date sqlDate(java.util.Date javaDate) {

		java.sql.Date sqlDate = null;
		if (javaDate != null) {
			sqlDate = new Date(javaDate.getTime());
		}
		return sqlDate;
	}

	//정보수정을 위한 ??이건 뭐지?
	@ResponseBody
	@GetMapping("/petInfoUpdate")
	public Optional<Pet> petInfoUpdate(@RequestParam(value = "petInfo")int petInfo){

		Optional<Pet> result = petRepo.findById(petInfo);
		return result;
	}


	//정보수정-----------------------------------
	@PostMapping("/petUpdate")
	public String petUpdate(Model model, Pet pet) {
		petCareService.updatePet(pet);
		petCareService.petCycleUpdate(pet);


		return "redirect:/petCare";
	}

	//삭제
	@ResponseBody
	@GetMapping("/petDelete")
	public void petDelete(@RequestParam(value = "deletePet")int deletePet) {
		petRepo.deleteById(deletePet);
		
	}

	//예제 연습란-------------------------------------------------------
	@GetMapping("/petDetails")
	public String details() {
		return "/petCare/petDetails";
	}


	//진단명
	@ResponseBody
	@GetMapping("/sClinic")
	public List<Sclinic> sClinic(@RequestParam(value="fCode")String fCode){

		//model.addAttribute("tClinic", tclinicRepo.getTclinic(s.));
		return sclinicRepo.getSclinic(fCode);
	}

	//진단명
	@ResponseBody
	@GetMapping("/tClinic")
	public List<Tclinic> tClinic(@RequestParam(value="sCode")String sCode){
		/*List<Tclinic> a = tclinicRepo.getTclinic(sCode);
		for (Tclinic s : a) {
			System.out.println(" : " + s.getTName());
		}*/
		return tclinicRepo.getTclinic(sCode);
	}

	//의료기록등록
	@PostMapping("/medicalInsert")
	public String medicalInsert(Medical medical) {
		medicalRepo.save(medical);
		
		//의료기록이랑 생애주기정보 등록
		petCareService.petCycleMedical(medical);
		
		return "redirect:/petCare";
	}

	//의료기록 정보수정
	@PostMapping("/medicalUpdate")
	public String medicalUpdate(Medical medical) {
		
		petCareService.updateMedical(medical);
		
		return "redirect:/petCare";
	}
	
	
	//의료기록삭제 - medical no
	@ResponseBody
	@GetMapping("/medicalDelete")
	public void medicalDelete(@RequestParam(value = "deleteMedical")int deleteMedical) {
		
		System.out.println("또각또각");
		petCareService.updateCheck(deleteMedical);
		medicalRepo.medicalDelete(deleteMedical);
		
		
	}
	//사진----------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value ="/upload/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> petUploadAjax(@RequestPart MultipartFile file ) throws Exception{ //,HttpServletRequest request //uploadPath =
		//request.getSession().getServletContext().getRealPath("/image/");

		logger.info("originalName: "+file.getOriginalFilename());
		logger.info("size: "+file.getSize());
		logger.info("contentType: "+file.getContentType());
		logger.info("uploadPath: "+uploadPath); 
		
		return new ResponseEntity<String>(ImageUploadUtils.imageUpload(uploadPath,file.getOriginalFilename(), file.getBytes()),HttpStatus.OK); 
		//return new ResponseEntity<String>(ImageUploadUtils.imageUpload(uploadPath,file.getOriginalFilename(), file.getBytes(),file),HttpStatus.OK); 
	}

	@ResponseBody
	@RequestMapping("/upload/displayFile") 
	public ResponseEntity<byte[]>displayFile(String fileName) throws Exception{

		InputStream in = null; 
		ResponseEntity<byte[]> entity = null;

		try {

			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName); 
			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath+fileName);

			if(mType !=null) { 
				headers.setContentType(mType);

			}else { 
				fileName = fileName.substring(fileName.indexOf("_")+1);

				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);


				headers.add("Content-Disposition", "attachment; filename=\'"
						+new String(fileName.getBytes("utf-8"),"iso-8859-1")+"\"");

			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.OK); 
		}catch(Exception e) {
			e.printStackTrace(); 
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST); }
		finally { 
			in.close(); 
		}
		return entity; 
	}


	@ResponseBody
	@RequestMapping(value = "/upload/deleteFile",method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){

		String formatName = fileName.substring(fileName.indexOf("_")+1);
		MediaType mType = MediaUtils.getMediaType(formatName);

		if(mType != null) {
			String front = fileName.substring(0,12);
			String end = fileName.substring(14);

			new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
		}

		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}


}