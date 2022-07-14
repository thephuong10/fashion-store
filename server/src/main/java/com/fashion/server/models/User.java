package com.fashion.server.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class User {

	@Id
	String id;

	String fullName;

	@Indexed(unique = true)
	String email;

	String password;

	@Indexed(unique = true)
	String phone;

	List<Role> roles = new ArrayList<>();

	Address address;

	String provider;

}
