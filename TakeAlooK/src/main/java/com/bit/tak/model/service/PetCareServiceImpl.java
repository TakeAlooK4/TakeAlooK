package com.bit.tak.model.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.tak.model.repository.BreedRepo;
import com.bit.tak.model.repository.FclinicRepo;
import com.bit.tak.model.repository.Life_cycleRepo;
import com.bit.tak.model.repository.MedicalRepo;
import com.bit.tak.model.repository.PetRepo;
import com.bit.tak.model.repository.Pet_cycleRepo;
import com.bit.tak.model.vo.clinic.Fclinic;
import com.bit.tak.model.vo.member.Muser;
import com.bit.tak.model.vo.pet.Breed;
import com.bit.tak.model.vo.pet.Life_Cycle;
import com.bit.tak.model.vo.pet.Medical;
import com.bit.tak.model.vo.pet.Pet;
import com.bit.tak.model.vo.pet.Pet_cycle;

@Service("petCareService")
public class PetCareServiceImpl implements PetCareService {

	@Autowired
	private BreedRepo breedRepo;
	@Autowired
	private PetRepo petRepo;
	@Autowired
	private FclinicRepo fclinicRepo;
	@Autowired
	private MedicalRepo medicalRepo;
	@Autowired
	private Pet_cycleRepo pet_cycleRepo;
	@Autowired
	private Life_cycleRepo life_cycleRepo;

	//품종
	@Override
	public List<Breed> getBreedList() {

		return breedRepo.findAll();
	}

	//아이디 찾아가기
	@Override
	public List<Pet> findByNickname(Muser nickname) {

		return petRepo.findByNickname(nickname);
	}

	//첫진단명
	@Override
	public List<Fclinic> getFclinic() {

		return fclinicRepo.findAll();
	}

	//의료기록
	@Override
	public List<Medical> findByPetId(Muser nickname,int petId) {

		return medicalRepo.findByPetId(nickname,petId);
	}

	//반려동물 정보수정
	@Override
	public void updatePet(Pet pet) {
		Pet findPet = petRepo.findById(pet.getPetId()).get();


		System.out.println("아아아아: "+findPet.getBreedCode().getBreedCode());
		findPet.setPetName(pet.getPetName());
		if(pet.getPetImg()!=null) {

			findPet.setPetImg(pet.getPetImg());
		}
		//findPet.setPetImg(pet.getPetImg());
		//System.out.println("????");
		findPet.setNickname(pet.getNickname());
		findPet.setPetCode(pet.getPetCode());
		/*
		 * if(pet.getBreedCode()!=null) {
		 * 
		 * }
		 */
		if(pet.getBreedCode()!=null) {
			findPet.setBreedCode(pet.getBreedCode());
		}
		findPet.setBreedCode(findPet.getBreedCode());
		findPet.setPetGender(pet.getPetGender());
		findPet.setPetBirth(pet.getPetBirth());

		//System.out.println("아오 왜 안나와"+ findPet);

		petRepo.save(findPet);
	}

	@Override
	public void updateMedical(Medical medical) {
		Medical oldMedical = medicalRepo.findById(medical.getMedicalNo()).get();
		System.out.println("아아아아: "+oldMedical);
		oldMedical.setClinicHos(medical.getClinicHos());
		oldMedical.setMedicalCost(medical.getMedicalCost());
		oldMedical.setMedicalDate(medical.getMedicalDate());
		oldMedical.setMedicalMemo(medical.getMedicalMemo());
		if(medical.getTCode()!=null) {
			oldMedical.setTCode(medical.getTCode());
		}
		oldMedical.setTCode(oldMedical.getTCode());
		medicalRepo.save(oldMedical);

	}

	@Override
	public void petCycleInsert(Pet pet) {
		//새로만들 펫사이클
		//틀
		List<Life_Cycle> Petcycle;

		//생일을 기준으로 받아야할 검사 접종 일 계산
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(pet.getPetBirth());

		//강아지 일때 생애주기 넣어주기
		if(pet.getPetCode().equals("D")) {

			Petcycle =  life_cycleRepo.getDLifeCycle(); 
			for (Life_Cycle d : Petcycle) {
				Pet_cycle cycle = new Pet_cycle();
				cal.add(Calendar.DATE, d.getClinicDate());		
				cycle.setPetId(pet);
				cycle.setLifeCycleNo(d);
				cycle.setClinicDate(sqlDate(cal.getTime()));
				pet_cycleRepo.save(cycle);
			}
		}else {

			Petcycle =  life_cycleRepo.getCLifeCycle();
			for (Life_Cycle d : Petcycle) {
				Pet_cycle cycle = new Pet_cycle();
				cal.add(Calendar.DATE, d.getClinicDate());			
				cycle.setPetId(pet);
				cycle.setLifeCycleNo(d);
				cycle.setClinicDate(sqlDate(cal.getTime()));
				pet_cycleRepo.save(cycle);
			}
		}
	}

	@Override
	public void petCycleUpdate(Pet pet) {
		//바꿀 펫 사이클
		pet_cycleRepo.getPetReset(pet.getPetId());

		petCycleInsert(pet);
	}


	//의료기록 넣기
	@Override
	public void petCycleMedical(Medical medical) {
		
		//왜 에러가 안나지?
		int cycleCode;
		if(pet_cycleRepo.petCycleE(medical.getPetId().getPetId(),medical.getMedicalDate())==0) {

			if(medical.getPetId().getPetCode().equals("D")) {			

				cycleCode = life_cycleRepo.cycleDCode(medical.getTCode().getTCode(),medical.getPetId().getPetId());
				System.out.println(cycleCode);

			}else {

				cycleCode = life_cycleRepo.cycleCCode(medical.getTCode().getTCode(),medical.getPetId().getPetId());
			}
			pet_cycleRepo.cycleCheck(medical.getMedicalDate(),medical.getPetId().getPetId(),cycleCode);
			System.out.println(cycleCode);
		}

	}

	public static java.sql.Date sqlDate(java.util.Date javaDate) {

		java.sql.Date sqlDate = null;
		if (javaDate != null) {
			sqlDate = new Date(javaDate.getTime());
		}
		return sqlDate;
	}


	//의료기록 삭제될때 접종확인도 없애기
	@Override
	public void updateCheck(int medicalNo) {
		
		//clinic_check를 업데이트하기위해서 필요한것
		Medical medicalInfo = medicalRepo.medicalInfo(medicalNo);
		int p = pet_cycleRepo.petCycleE(medicalInfo.getPetId().getPetId(),medicalInfo.getMedicalDate());
		System.out.println("fewf: "+p);
		pet_cycleRepo.updateCheck(medicalInfo.getPetId().getPetId(), p);
		
	}
}
