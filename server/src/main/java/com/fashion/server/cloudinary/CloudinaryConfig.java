package com.fashion.server.cloudinary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
@PropertySource(value = "classpath:properties.properties")
public class CloudinaryConfig {

	@Value("${cloud.key}")
	private String cloudKey;
	
	@Value("${cloud.name}")
	private String cloudName;
	
	@Value("${cloud.secret}")
	private String cloudSecret;
	
	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(
				 ObjectUtils.asMap("cloud_name", cloudName,
				                   "api_key", cloudKey,
				                   "api_secret", cloudSecret,
				                   "secure", true)
				               );
	}
	
}
