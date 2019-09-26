
package com.bit.tak.model.repository;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bit.tak.model.vo.member.Muser;
import com.bit.tak.model.vo.product.Cart;



public interface CartRepo extends JpaRepository<Cart, Integer> {
	

	@Query(value="select cart_no, c.nickname , pr_name, p.pr_no,pr_cost,cart_amount, ifnull(pr_cost*cart_amount,0) money from team4.cart c, team4.product p, team4.	muser u where c.nickname=u.nickname and c.pr_no=p.pr_no", nativeQuery=true)
	public List<Cart> listCart(Muser user);

	@Query(value="select  ifnull(sum(pr_cost*cart_amount),0) money from team4.product p, team4.cart c, team4.Muser u  where p.pr_No=c.pr_No and u.nickname=c.nickname",nativeQuery=true)
	 	public int sumMoney(Muser user);
	
	@Transactional
	@Modifying
	@Query(value="delete from team4.cart where cart_no=?" , nativeQuery = true)
		int deleteByCart(Cart cart);

	
}
