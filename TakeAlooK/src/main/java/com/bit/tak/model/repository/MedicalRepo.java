package com.bit.tak.model.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bit.tak.model.vo.member.Muser;
import com.bit.tak.model.vo.pet.Medical;
import com.bit.tak.model.vo.pet.Pet;


@Repository
public interface MedicalRepo extends JpaRepository<Medical, Integer>{
	
	//@Query(value = "SELECT * FROM medical WHERE pet_id =?1",nativeQuery=true)
	@Query(value = "SELECT * FROM medical INNER JOIN pet ON medical.pet_id = pet.pet_id AND pet.nickname =?1 AND pet.pet_id=?2 order by medical_date asc",nativeQuery=true)
	List<Medical> findByPetId(Muser nickname,int petId);
	
	
	//의료기록 가져오깅
	@Query(value ="SELECT * FROM medical WHERE medical_no =?1",nativeQuery=true)
	Medical medicalInfo(int medicalNo);
	
	
	//update 나 delete 수행시 
	@Modifying
	@Transactional
	@Query(value ="DELETE FROM medical 	WHERE medical_no =?1",nativeQuery=true)
	void medicalDelete(int deleteMedical);
	
	
	
	/*
	 * @Query(
	 * value="select sum(medical_cost) from medical INNER JOIN pet ON medical.pet_id = pet.pet_id AND pet.nickname =?1"
	 * ,nativeQuery=true) List<Pet> findByPetMoneyTotal(User nickname);
	 * 
	 * @Query(
	 * value="select count(medical_cost) from medical INNER JOIN pet ON medical.pet_id = pet.pet_id AND pet.nickname =?1"
	 * ,nativeQuery=true) List<Pet> findByPetMoneyCount(User nickname);
	 */ 
}