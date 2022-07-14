package com.fashion.server.repositories;

import com.fashion.server.models.ProductVariantModel;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface IProductVariantRepository extends MongoRepository<ProductVariantModel, String> {

	
}
