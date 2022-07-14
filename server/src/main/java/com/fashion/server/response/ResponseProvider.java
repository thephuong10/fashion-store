package com.fashion.server.response;

public class ResponseProvider {

	private static final Response RESPONSE = new Response();
	
	public static class Auth {
		
		public static final Response USER_NOT_FOUND = 
				new Response(404,RESPONSE.new Message("Tài khoản không tồn tại", "Account not found"));
		
		public static final Response USER_ALREADY_EXISTS = 
				new Response(409,RESPONSE.new Message("Người dùng đã tồn tại", "User already exists"));
		
		public static final Response INVALID_ACCOUNT = 
				new Response(401,RESPONSE.new Message("Tài khoản hoặc mật khẩu không đúng", "Invalid account or password"));
		
		public static final Response INVALID_PASSWORD = 
				new Response(401,RESPONSE.new Message("Mật khẩu không đúng", "Invalid password"));
	
		public static final Response INVALID_EMAIL = 
				new Response(401,RESPONSE.new Message("Email không hợp lệ", "Invalid email"));
		
		public static final Response INVALID_OTP = 
				new Response(401,RESPONSE.new Message("OTP không hợp lệ", "Invalid otp"));
		
		public static final Response INVALID_TOKEN = 
				new Response(401,RESPONSE.new Message("Token không hợp lệ", "Invalid token"));
		
		public static final Response INVALID_TOKEN_EXPIRED = 
				new Response(401,RESPONSE.new Message("Token đã hết hạn", "Token expired"));
		
		public static final Response INVALID_CREDENTIALS = 
				new Response(401,RESPONSE.new Message("Thông tin không hợp lệ", "Invalid credentials"));
		
	}
	
}
