package com.fashion.server.repositories;

import com.fashion.server.models.CategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface ICategoryRepository extends MongoRepository<CategoryModel, String> {
	
	CategoryModel findOneByName(String name);
	
}
