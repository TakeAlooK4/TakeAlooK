package com.bit.tak.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bit.tak.model.vo.member.Muser;
import com.bit.tak.model.vo.product.Cart;
import com.bit.tak.model.vo.product.P_payment;




public interface PaymentRepo extends JpaRepository<P_payment,Integer> {

	@Transactional
	@Modifying
	@Query(value="delete from team4.p_payment where paymentno=?" , nativeQuery = true)
		int deleteById(P_payment payment);

	
}
