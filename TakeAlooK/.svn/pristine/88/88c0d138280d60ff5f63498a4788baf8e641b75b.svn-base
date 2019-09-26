package com.bit.tak.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bit.tak.model.vo.community.Ccomment;
import com.bit.tak.model.vo.community.Community;

public interface CcommentRepo extends JpaRepository<Ccomment, Integer>{
	
	@Query(value = "SELECT COUNT(*) FROM c_comment", nativeQuery = true)
	int commentCount();

	
	@Query(value = "select * from c_comment  where comm_no = ?1",nativeQuery = true)
	List<Ccomment> findByCommNo(int commNo); 
	 
	
}
