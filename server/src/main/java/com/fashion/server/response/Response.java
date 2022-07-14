package com.fashion.server.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public class Message {
		
		private String vi;
		private String en;	
		
	}
	
	private int status;
	private Message message;
	
}
