package com.fashion.server.services;



import com.fashion.server.models.CategoryModel;

import java.util.List;



public interface ICategoryService {

	List<CategoryModel>getAll();
	
	CategoryModel create(CategoryModel category);
	
}
