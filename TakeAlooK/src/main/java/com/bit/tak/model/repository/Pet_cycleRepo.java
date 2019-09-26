package com.bit.tak.model.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bit.tak.model.vo.pet.Pet;
import com.bit.tak.model.vo.pet.Pet_cycle;



public interface Pet_cycleRepo extends JpaRepository<Pet_cycle, Integer>{

	//life_cycle_no,clinic_date
	@Query(value = "select * from pet_cycle  where pet_id = ?1",nativeQuery=true)
	List<Pet_cycle> getTCycle(int petId);

	
	@Query(value = "select * from pet_cycle  where pet_id = ?1 and clinic_check is null order by abs(datediff(curdate(), pet_cycle.clinic_date)) asc limit 1",nativeQuery=true) 
	Pet_cycle getCycle(int petId);
	
	//현재 날짜보다 예전인 날짜의 데이터 가져오기
	@Query(value = "select * from pet_cycle  where pet_id = ?1 and clinic_check is null and clinic_date < CURRENT_DATE()",nativeQuery=true) 
	List<Pet_cycle> getUCycle(int petId);
 
	@Modifying
	@Transactional
	@Query(value = "delete from pet_cycle  where pet_id = ?1",nativeQuery=true)
	void getPetReset(int petId);

	@Query(value = "select EXISTS (SELECT * FROM pet_cycle INNER JOIN medical on pet_cycle.pet_id = medical.pet_id  where pet_cycle.clinic_check = medical.medical_date  and  pet_cycle.pet_id = ?1 and medical.medical_date = ?2) as success",nativeQuery =true)
	int petCycleE(int petId, Date medicalDate);
	
	@Query(value = "SELECT life_cycle_no FROM pet_cycle INNER JOIN medical on pet_cycle.pet_id = medical.pet_id  where pet_cycle.clinic_check = medical.medical_date  and  pet_cycle.pet_id = ?1 and medical.medical_date = ?2",nativeQuery =true)
	int petCycleM(int petId, Date medicalDate);

	@Modifying
	@Transactional
	@Query(value ="UPDATE pet_cycle SET clinic_check = ?1 WHERE pet_id = ?2 AND life_cycle_no = ?3",nativeQuery=true)
	void cycleCheck(Date clinicCheck,int id, int no);

	
	//의료기록 삭제하면 다시 맞아야 한다고 알려두는  생애주기 - 쿼리는 맞음
	@Modifying
	@Transactional
	@Query(value ="UPDATE pet_cycle SET clinic_check = null WHERE pet_id = ?1 AND life_cycle_no = ?2",nativeQuery=true)
	void updateCheck(int id, int no);
}

