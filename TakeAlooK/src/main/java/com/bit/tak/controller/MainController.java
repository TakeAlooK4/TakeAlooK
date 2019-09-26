package com.bit.tak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.tak.model.repository.ProductRepo;
import com.bit.tak.model.vo.product.Product;

@Controller
public class MainController {
	
	@Autowired
	ProductRepo productRepo;
	
	// 메인페이지 뷰
	@RequestMapping("/")
	public String mainPage(Model model) {
		List<Product> findlist = productRepo.mainList();
		model.addAttribute("main", findlist);	
		List<Product> allList = productRepo.allList();
		model.addAttribute("allList", allList);
		return "index";
	}
	
	// 마이페이지 뷰
	@RequestMapping("/myPage")
	public String myPage() {
		return "mypage/myPage";
	}
	
	// 구매내역 페이지 뷰
	@RequestMapping("/orderList")
	public String orderListPage() {
		return "mypage/orderList";
	}
	
	// 장바구니 페이지 뷰
	@RequestMapping("/productCart")
	public String productCartPage() {
		return "product/productCart";
	}
	
	
}
