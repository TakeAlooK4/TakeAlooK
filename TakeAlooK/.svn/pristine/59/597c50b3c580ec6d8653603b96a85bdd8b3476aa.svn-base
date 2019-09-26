package com.bit.tak.model.service;

import java.sql.Date;
import java.util.List;

import com.bit.tak.model.vo.clinic.Fclinic;
import com.bit.tak.model.vo.member.Muser;
import com.bit.tak.model.vo.pet.Breed;
import com.bit.tak.model.vo.pet.Life_Cycle;
import com.bit.tak.model.vo.pet.Medical;
import com.bit.tak.model.vo.pet.Pet;
import com.bit.tak.model.vo.pet.Pet_cycle;

public interface PetCareService {

	List<Breed> getBreedList();
	List<Pet> findByNickname(Muser nickname);
	List<Fclinic> getFclinic();
	//아이디로 사진 찾기
	List<Medical> findByPetId(Muser nickname,int petId);
	void updatePet(Pet pet);
	void updateMedical(Medical medical);
	
	void petCycleInsert(Pet pet);
	void petCycleUpdate(Pet pet);
	void petCycleMedical(Medical medical);
	void updateCheck(int medicalNo);
	 
	
	
}
