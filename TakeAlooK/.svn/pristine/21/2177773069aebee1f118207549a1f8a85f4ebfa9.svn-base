package com.bit.tak.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bit.tak.model.vo.productCode.P_Age;
@Repository
public interface P_ageRepo extends JpaRepository<P_Age, String> {
	
	@Query(value = "SELECT * FROM P_age", nativeQuery = true)
	List<P_Age> pAgeList();
}
