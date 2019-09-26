package com.bit.tak.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bit.tak.model.vo.productCode.P_Code;

@Repository
public interface P_codeRepo extends JpaRepository<P_Code, String> {
	
	@Query(value = "SELECT  * FROM P_code WHERE p_code like %?1% and not p_name like %?2% ", nativeQuery = true)
	List<P_Code> pCodeList(String pCode, String p_name);
	
	
	

}
