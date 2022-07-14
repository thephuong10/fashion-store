package com.fashion.server.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {

	private Integer provinceId;
	
	private String provinceName;
	
	private Integer districtId;
	
	private String districtName;
	
	private String wardCode;
	
	private String wardName;
	
	private String addressDetail;
	
}
