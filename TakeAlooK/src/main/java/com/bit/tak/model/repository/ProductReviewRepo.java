
package com.bit.tak.model.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bit.tak.model.vo.admin.P_Review;
import com.bit.tak.model.vo.member.Muser;
import com.bit.tak.model.vo.product.Product;

public interface ProductReviewRepo extends JpaRepository<P_Review, Integer> {

	@Query(value="select * from team4.p_review where pr_no=?",nativeQuery=true)
	List<P_Review> findByReviewId(int prNo);
	
	@Transactional
	@Modifying
	@Query(value="delete from team4.p_review where review_no=?" , nativeQuery = true)
	int deleteById(P_Review reviewNo);
}
//sssss
//