package com.bit.tak.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bit.tak.model.vo.clinic.Sclinic;
@Repository
public interface SclinicRepo extends JpaRepository<Sclinic, String> {

	
	  @Query(value="SELECT * FROM sclinic WHERE f_code = ?1",nativeQuery=true)
	  List<Sclinic> getSclinic(String fCode);
	 
}
