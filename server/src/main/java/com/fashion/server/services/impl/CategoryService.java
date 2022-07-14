package com.fashion.server.services.impl;

import com.fashion.server.exceptions.ObjectAlreadyExitsException;
import com.fashion.server.models.CategoryModel;
import com.fashion.server.repositories.ICategoryRepository;
import com.fashion.server.services.ICategoryService;
import com.fashion.server.util.HandleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository iCategoryRepository;
	
	
	
	
	@Override
	public List<CategoryModel> getAll() {
		
		return iCategoryRepository.findAll();
		
	}


	@Override
	public CategoryModel create(CategoryModel category) {
		
		if(exitsByName(category.getName())) {
			
			throw new ObjectAlreadyExitsException("Category");
		}
			
		category.setSlug(HandleUtils.generateSlug(category.getName()));
		
		return iCategoryRepository.save(category);
		
		
	}

	
	private Boolean exitsByName(String name) {
		
		return Optional
				.ofNullable(iCategoryRepository.findOneByName(name))
				.map(c -> true)
				.orElse(false);
		
	}



	
}
