package com.bit.tak.model.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bit.tak.model.vo.product.Cart;
import com.bit.tak.model.vo.product.Product;

public interface ProductRepo extends JpaRepository<Product,Integer > {
		//사료만 다 가져오게 하는 쿼리
		@Query(value="SELECT * FROM TEAM4.PRODUCT WHERE P_CODE LIKE '%fc%'" , nativeQuery=true)
		public List<Product> feedAllList(String pCode);
		//간식만 다나오게 하는 쿼리
		@Query(value="SELECT * FROM TEAM4.PRODUCT WHERE P_CODE LIKE '%sn%'" , nativeQuery=true)
		public List<Product> snackAllList(String pCode);
		//목욕/미용 용품 불러오는 쿼리
		@Query(value="SELECT * FROM TEAM4.PRODUCT WHERE P_CODE LIKE 'ba%'" , nativeQuery=true)
		public List<Product> bueatyAllList(String pCode);
		//기타 용품
		@Query(value="SELECT * FROM TEAM4.PRODUCT WHERE P_CODE LIKE 'op%'" , nativeQuery=true)
		public List<Product> orderAllList(String pCode);
		// 강아지 고양이 메인 a 태그 쿼리
		@Query(value="select * from team4.product where animal_type=?1 and p_code='Dfc01' OR P_CODE='CFC01'", nativeQuery=true)
		public List<Product> feedList(String animalType); 

		@Query(value="select * from team4.product where animal_type=?1 and p_code=?2", nativeQuery=true)
		public List<Product> foodList(String animalType,String pCode); 
		
		
		// 세부 메뉴 쿼리
		//0.순위
		@Query(value="select * from team4.product where animal_Type='D'", nativeQuery=true)
		public Product dogList(String animalType);
		
		@Query(value="select * from team4.product where animal_Type='C'", nativeQuery=true)
		public Product catList(String animalType);
		
		@Query(value="select * from team4.product where animal_type=?1 and p_code=?2 or p_code=?3 or p_code=?4", nativeQuery=true)
		public List<Product> proList(String animalType,String pCode1,String pCode2,String pCode3); 
		
		// 진선
		@Query(value = "SELECT * FROM product where c_no =?1", nativeQuery = true)
		public List<Product> getCompanyProduct(String cNo);
		
		//index 출력
		@Query(value = "select * from product order by pr_no desc limit 6;", nativeQuery = true)
		public List<Product> mainList();
		
		@Query(value = "select * from product order by rand() limit 0, 4;", nativeQuery = true)
		public List<Product> allList();
		

}	
	
		
