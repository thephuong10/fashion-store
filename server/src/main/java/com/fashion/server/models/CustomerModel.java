package com.fashion.server.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "customer")
public class CustomerModel extends User {

	@DBRef
	private List<CartModel> carts = new ArrayList<>();
	
}
