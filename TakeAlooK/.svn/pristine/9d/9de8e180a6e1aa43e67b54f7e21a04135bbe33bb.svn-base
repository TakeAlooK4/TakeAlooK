package com.bit.tak.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bit.tak.model.vo.member.Muser;

@Repository
public interface MemberRepo extends JpaRepository<Muser, String> {
	
	// 회원가입 쿼리문
		@Query("SELECT u FROM Muser u where u.id = ?1 and u.password = ?2")
		Muser findByUser(String id, String password);
		
		// 아이디 중복확인 쿼리문
		@Query(value =  "select * from Muser where id = ?", nativeQuery = true)
		Muser findId(String id);
		
		// 닉네임 중복확인 쿼리문
		@Query(value = "select * from Muser where nickname =?", nativeQuery = true)
		Muser findNickname(String nickname);
		
		// 핸드폰번호 중복확인 쿼리문
		@Query(value = "select * from Muser where contact =?", nativeQuery = true)
		Muser findContact(String contact);
		
		// 아이디 찾기 쿼리문
		@Query(value = "select id from Muser where name = ? and contact = ?", nativeQuery = true)
		String searchId(String name, String contact);
		
		// 유저 비밀번호 찾기 쿼리문
		@Query(value = "select password from Muser where name = ? and id = ?", nativeQuery = true)
		String searchPw(String name, String id);
	
}
