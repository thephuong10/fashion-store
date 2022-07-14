package com.fashion.server.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rating {

	private Double starAverage;
	
	private List<Integer>totalUserByStar;
	
}
