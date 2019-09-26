package com.bit.tak.model.repository;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bit.tak.model.vo.community.CommLike;

public interface LikeRepo extends JpaRepository<CommLike, String>{

	@Query(value = "select count(*) from comm_like where comm_no = ?1 and nickname = ?2", nativeQuery = true)
	public int likeCheck(int commNo, String nickname);
	
	@Query(value = "insert into comm_like(comm_no, nickname) value(?1, ?1)", nativeQuery = true)
	public void likeUpdate(CommLike commLike);
	
	@Modifying
	@Transactional
	@Query(value = "delete from comm_like where comm_no = ?1 and nickname = ?2", nativeQuery = true)
	public void likeDelete(int commNo, String nickname);
	
	@Query(value = "select count(*) from comm_like where comm_no = ?1", nativeQuery = true)
	public int likeCount(int no);
	
	@Query(value = "select nickname from comm_like where comm_no = ?1 and nickname = ?2",nativeQuery = true)
	public String commNO(int commNo, String nickname);
}
