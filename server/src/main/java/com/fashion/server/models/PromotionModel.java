package com.fashion.server.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "promotion")
public class PromotionModel {

	@Id
	private Long id;
	
	private String avatar;
	
	private Double discount;
	
	private Date timeStart;
	
	private Date timeEnd;
	
	
}
