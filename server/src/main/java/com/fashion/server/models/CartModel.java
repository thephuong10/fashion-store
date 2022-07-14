package com.fashion.server.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "cart")
public class CartModel {
	
	@Id
	private String id;
 
	private Double discount;
 
	private Product product;
	
}
