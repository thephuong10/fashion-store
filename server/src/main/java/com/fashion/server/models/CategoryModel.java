package com.fashion.server.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "category")
public class CategoryModel {

	@Id
	private String id;
	private String name;
	private String slug;
	private String parentId;
}
