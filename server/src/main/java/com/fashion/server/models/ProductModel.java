package com.fashion.server.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "product")
public class ProductModel {

	@Id
    private String id;
	
	private String categoryId;
	
	private String slug;
	
    private String name;
	
    private Integer quantity;
    
    private String description;
    
    private Integer selled;
    
    private Date createDate;
    
    private BigDecimal maxPrice;
    
    private BigDecimal minPrice;
	
    @DBRef(lazy = true)
    private List<ProductVariantModel>variants = new ArrayList<>();
    
    private Rating rating;
    
    @DBRef
    private PromotionModel promotion;
    
}
