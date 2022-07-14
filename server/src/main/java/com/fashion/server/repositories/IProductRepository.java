package com.fashion.server.repositories;

import com.fashion.server.models.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;




public interface IProductRepository extends MongoRepository<ProductModel, String> {

	Page<ProductModel>findAllByCategoryId(String menuId,Pageable pageable);
	
}
