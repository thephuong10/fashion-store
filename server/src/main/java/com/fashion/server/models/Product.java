package com.fashion.server.models;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

	private String id;
	
	private String name;
	
	private BigDecimal price;
	
	private Long quantity;
	
	private String avatar;
	
	private String color;
	
	private String size;
	
}
