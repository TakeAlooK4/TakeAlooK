package com.bit.tak.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.bit.tak.model.vo.pet.Life_Cycle;

public interface Life_cycleRepo extends JpaRepository<Life_Cycle, Integer>{

	@Query(value = "SELECT * FROM life_cycle WHERE life_cycle_no<=21",nativeQuery=true)
	List<Life_Cycle> getDLifeCycle();
	
	@Query(value = "SELECT * FROM life_cycle WHERE life_cycle_no>21",nativeQuery=true)
	List<Life_Cycle> getCLifeCycle();
	
	@Query(value ="select  life_cycle.life_cycle_no from life_cycle inner join pet_cycle on life_cycle.life_cycle_no = pet_cycle.life_cycle_no where pet_cycle.clinic_check is null and life_cycle.t_code= ?1 and life_cycle.life_cycle_no<=21 and pet_cycle.pet_id = ?2 limit 1;  "
			,nativeQuery=true)
	int cycleDCode(String tCode,int petId);
	
	@Query(value ="select  life_cycle.life_cycle_no from life_cycle inner join pet_cycle on life_cycle.life_cycle_no = pet_cycle.life_cycle_no where pet_cycle.clinic_check is null and life_cycle.t_code= ?1 and life_cycle.life_cycle_no>21 and pet_cycle.pet_id = ?2 limit 1; "
			,nativeQuery=true)
	int cycleCCode(String tCode,int petId);
	
}