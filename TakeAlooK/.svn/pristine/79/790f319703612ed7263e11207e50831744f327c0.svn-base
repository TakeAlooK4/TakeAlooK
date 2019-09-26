package com.bit.tak.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bit.tak.model.vo.productCode.P_Fp;

@Repository
public interface P_fpRepo extends JpaRepository<P_Fp, String> {

	@Query(value = "SELECT * FROM P_fp", nativeQuery = true)
	List<P_Fp> pFpList();
}
