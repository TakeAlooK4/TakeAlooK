package com.bit.tak.model.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bit.tak.model.vo.member.Muser;
import com.bit.tak.model.vo.product.Cart;
import com.bit.tak.model.vo.product.P_resultValue;

public interface P_resultValueRepo extends JpaRepository<P_resultValue, Integer> {


//	@Query(value="select main_Img01 from team4.product where pr_no=?", nativeQuery=true)
//	Product findByPrNo(Product prNo);
	
	@Query(value="select  ifnull(sum(sum_value),0) money  from  team4.p_result_value r, team4.cart c  where c.cart_No=r.cart_No ;",nativeQuery=true)
 	public int sumAllMoney(Cart cartNo);
	
	@Query(value="select sum_value from team4.p_result_value where result_value=?" ,nativeQuery=true)
	List<P_resultValue> findByResultValue(int resultValue);
	
	@Query(value="select sum_value from team4.p_result_value ORDER BY result_value DESC limit 1;", nativeQuery = true)
	int sumResultValue(P_resultValue resultValue);

}
