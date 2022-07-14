package com.fashion.server.services.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fashion.server.cloudinary.CloudinaryHandle;
import com.fashion.server.models.ProductModel;
import com.fashion.server.models.ProductVariantModel;
import com.fashion.server.models.Rating;
import com.fashion.server.repositories.IProductRepository;
import com.fashion.server.repositories.IProductVariantRepository;
import com.fashion.server.services.IProductService;
import com.fashion.server.util.HandleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;



@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository iProductRepository;
	
	@Autowired
	private IProductVariantRepository iProductVariantRepository;
	
	@Autowired 
	private CloudinaryHandle cloudinary;
	
	@Override
	public ProductModel create(ProductModel p) {
		
		
		p.setSlug(HandleUtils.generateSlug(p.getName()));
		p.setQuantity(0);
		p.setMinPrice(p.getVariants().get(0).getPriceOriginal());
		p.setMaxPrice(p.getVariants().get(0).getPriceOriginal());
		p.setVariants(
		  p.getVariants()
		    .stream()
		     .map(pv -> {
		    	
		    	p.setMinPrice(p.getMinPrice().compareTo(pv.getPriceOriginal()) > 0 ? pv.getPriceOriginal() : p.getMinPrice()); 
		    	p.setMaxPrice(p.getMaxPrice().compareTo(pv.getPriceOriginal()) < 0 ? pv.getPriceOriginal() : p.getMaxPrice()); 
		    	p.setQuantity(p.getQuantity()+pv.getQuantity());
		    	
		    	return createVariant(pv);
		    })
		    .collect(Collectors.toList())
		 );
		
		p.setRating(createRating());
		
		p.setSelled(0);
		
		p.setCreateDate(new Date(System.currentTimeMillis()));
		
		return iProductRepository.save(p);
		
	}

	private ProductVariantModel createVariant(ProductVariantModel pv) {
		
		pv.setPrice(pv.getPriceOriginal());
		
		return iProductVariantRepository.save(pv);
	}
	
	private Rating createRating() {
		
		Rating rating = new Rating();
		
		rating.setStarAverage(0.0);
		
		rating.setTotalUserByStar(Arrays.asList(0,0,0,0,0));
		
		return rating;
	}
	
	@Override
	public List<ProductModel> getAll(Pageable pageable) {
		
		return iProductRepository
				.findAll(pageable)
				.getContent()
				.stream()
				 .map(p->{
				   p.setVariants(Arrays.asList(p.getVariants().get(0)));
				   return p;
				 })
				 .collect(Collectors.toList())
				 ;
	}

	@Override
	public List<ProductModel> getAllByCategoryId(String categoryId, Pageable pageable) {
		
		return iProductRepository.findAllByCategoryId(categoryId, pageable).getContent();
	}


	@Override
	public ProductModel getOneById(String id) {
		
		return Optional
				.ofNullable(iProductRepository.findById(id).get())
				.map(f -> {
					
					return f;
				})
				.orElseThrow(()-> new NotFoundException("Not found"));
		
	}

	@Override
	public ProductModel update(ProductModel p) {
		
		Optional<ProductModel> productOptional = iProductRepository.findById(p.getId());
	
		
		if(!productOptional.isPresent()) {
			
			throw new NotFoundException("Not found");
		}
		
		ProductModel pOld = productOptional.get();
		
		for (int i = 0; i < pOld.getVariants().size(); i++) {
			
			for (int j = 0; j < p.getVariants().size(); j++) {
				
				if(pOld.getVariants().get(i).getId().equals(p.getVariants().get(j).getId())) {
					
					pOld.getVariants().set(i, updateVariant(pOld.getVariants().get(i),p.getVariants().get(j)));
									
					break;
				}
				
			}
		}
		
		
		List<ProductVariantModel>variants= pOld.getVariants();
		
		p.setVariants(null);
		pOld.setVariants(null);
		
		ProductModel pNew = (ProductModel) HandleUtils.mergeEntity(p, pOld);
		
		pNew.setVariants(variants);
		
		pNew.setQuantity(0);
		pNew.setMinPrice(pNew.getVariants().get(0).getPriceOriginal());
		pNew.setMaxPrice(pNew.getVariants().get(0).getPriceOriginal());
		pNew.setVariants(
		  pNew.getVariants()
		    .stream()
		     .map(pv -> {
		    	
		    	pNew.setMinPrice(pNew.getMinPrice().compareTo(pv.getPriceOriginal()) > 0 ? pv.getPriceOriginal() : pNew.getMinPrice()); 
		    	pNew.setMaxPrice(pNew.getMaxPrice().compareTo(pv.getPriceOriginal()) < 0 ? pv.getPriceOriginal() : pNew.getMaxPrice()); 
		    	pNew.setQuantity(pNew.getQuantity()+pv.getQuantity());
		    	
		    	return pv;
		    })
		    .collect(Collectors.toList())
		 );
		
		return iProductRepository.save(pNew);
		
	}
	
	private ProductVariantModel updateVariant(ProductVariantModel pvOld,ProductVariantModel pvNew) {
		
		
		return (ProductVariantModel) HandleUtils.mergeEntity(pvNew,pvOld);
		
		
	}
	
	
}
