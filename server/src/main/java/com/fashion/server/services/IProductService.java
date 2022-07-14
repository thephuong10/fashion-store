package com.fashion.server.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.fashion.server.models.ProductModel;


public interface IProductService {

	ProductModel create(ProductModel product);
	
	ProductModel update(ProductModel product);
	
	List<ProductModel>getAll(Pageable pageable);
	
	List<ProductModel>getAllByCategoryId(String categoryId,Pageable pageable);
	
	ProductModel getOneById(String id);
	
}
