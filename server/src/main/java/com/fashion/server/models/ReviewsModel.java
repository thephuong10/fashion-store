package com.fashion.server.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "reviews")
@CompoundIndex(name = "product_user",def = "{'productId' : 1, 'userId': 1}",unique = true)
public class ReviewsModel {

	@Id
	private String id;
	
	private String content;
	
	private List<String>images= new ArrayList<>();
	
	private Integer star;
	
	private String productId;
	
	private String userId;
	
	private String status;
	
	
}
