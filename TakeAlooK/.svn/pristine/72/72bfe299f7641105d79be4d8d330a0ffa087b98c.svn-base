package com.bit.tak.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bit.tak.model.vo.pet.Breed;

public interface BreedRepo extends JpaRepository<Breed, String>{
	
	List<Breed> findByBreedCodeStartingWith(String petCode);
}
