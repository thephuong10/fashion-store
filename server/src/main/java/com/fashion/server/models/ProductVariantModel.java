package com.fashion.server.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "product_variant")
@ToString
public class ProductVariantModel {

	@Id
	private String id;
	
	private Integer quantity;
	
	private String avatar;
	
	private List<String>pictures = new ArrayList<>();
	
	private String color;
	
	private String size;
	
	private BigDecimal priceOriginal;
    
    private BigDecimal price; // priceOriginal * (1 - discount)
    
    
}
