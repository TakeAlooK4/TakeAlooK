package com.bit.tak.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bit.tak.model.vo.member.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, String>{
	@Query("SELECT c FROM Company  c WHERE c.cNo = ?1 AND c.cPassword = ?2")
	//@Query(value = "SELECT * FROM Company WHERE c_no = ?1 AND c_password = ?2", nativeQuery = true)
	Company findByCompany(String cNo, String cPassword);
	
	// 사업자번호 중복확인 쿼리
	@Query(value = "select * from Company where c_no = ?", nativeQuery = true)
	Company findCNo(String cNo);
	
	// 기업 대표 번호 중복확인 쿼리
	@Query(value = "select * from Company where c_phone = ?", nativeQuery = true)
	Company findCPhone(String cPhone);
	
	// 사업자번호 아이디 찾기 쿼리문
	@Query(value = "select c_no from company where c_name = ? and c_phone = ?", nativeQuery = true)
	String searchCompanyNo(String cName, String cPhone);
	
	// 사업자번호 비밀번호 찾기 쿼리문
}
