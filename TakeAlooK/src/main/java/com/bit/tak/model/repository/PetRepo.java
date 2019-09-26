package com.bit.tak.model.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bit.tak.model.vo.member.Muser;
import com.bit.tak.model.vo.pet.Pet;

@Repository
public interface PetRepo extends JpaRepository<Pet, Integer>{
	
	//@Query("SELECT p FROM PET p WHERE p.petID=?1")
	//Pet getPetCareList(int nickname); 
	List<Pet> findByNickname(Muser nickname);
	
	@Query(value="SELECT curdate()", nativeQuery=true)
	Date curdate();
	
	@Query(value="SELECT min(pet_id) FROM pet WHERE nickname = ?1", nativeQuery=true)
	int minPetId(Muser user);

	@Query(value="SELECT EXISTS(SELECT pet_id FROM pet WHERE nickname = ?1) AS isChk", nativeQuery=true)
	int existPetId(Muser user);
}