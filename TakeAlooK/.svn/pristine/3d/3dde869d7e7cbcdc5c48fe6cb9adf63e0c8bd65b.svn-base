package com.bit.tak.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bit.tak.model.vo.clinic.Sclinic;
import com.bit.tak.model.vo.clinic.Tclinic;

@Repository
public interface TclinicRepo extends JpaRepository<Tclinic, String> {
	
	//@Query(value = "SELECT * FROM tclinic t INNER JOIN sclinic s ON t.s_code = s.s_code WHERE s.f_code=?1",nativeQuery=true)
	//List<Tclinic> getSclinic(String fcode);
	
	@Query(value="SELECT * FROM tclinic WHERE s_code = ?1",nativeQuery=true)
	List<Tclinic> getTclinic(String sCode);
}
