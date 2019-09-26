package com.bit.tak.model.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bit.tak.model.vo.community.Community;

public interface CommunityRepo extends JpaRepository<Community, Integer>, QuerydslPredicateExecutor<Community> {

	/*
	 * @Query(value = "SELECT c FROM Community c ORDER BY c.commNo desc")
	 * Page<Community> findAllList(Pageable pageable, Predicate predicate); //리스트 출력
	 * 순서
	 */	
	@Query(value = "select comm_no from community", nativeQuery = true)
	List<Community> BoardCnt();

	@Query(value = "select * from community where nickname = ?1 order by comm_no desc", nativeQuery = true)
	List<Community> findByNickname(String nickname);

	@Modifying
	@Transactional
	@Query(value = "delete from community where comm_no = ?1", nativeQuery = true)
	int deleteMyContent(int aa);
	
	
}
