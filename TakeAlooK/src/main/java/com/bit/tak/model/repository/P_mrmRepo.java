package com.bit.tak.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bit.tak.model.vo.productCode.P_Mrm;

@Repository
public interface P_mrmRepo extends JpaRepository<P_Mrm, String> {
	
	@Query(value = "SELECT * FROM P_mrm", nativeQuery = true)
	List<P_Mrm> pAgeList();
}
