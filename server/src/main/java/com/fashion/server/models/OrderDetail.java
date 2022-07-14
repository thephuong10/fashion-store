package com.fashion.server.models;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDetail {

	private Product product;
	
	private BigDecimal totalMoney;
	
	private Integer quantity;
	
}
