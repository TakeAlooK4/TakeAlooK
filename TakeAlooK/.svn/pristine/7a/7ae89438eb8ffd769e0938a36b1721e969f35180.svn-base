package com.bit.tak.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.tak.model.repository.CartRepo;
import com.bit.tak.model.repository.ProductRepo;

import com.bit.tak.model.vo.product.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo repo;
	
	@Autowired
	CartRepo cartRepo;
	
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	

}