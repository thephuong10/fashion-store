package com.fashion.server.cloudinary;

import java.io.IOException;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Component
public class CloudinaryHandle {

	private final String FOLDER_NAME = "foodWorld";
	
	@Autowired
	private Cloudinary cloudinary;
	
	
	public String upload(byte[] bytes) {

		try {
			
			return (String) cloudinary.uploader()
					.upload(
					  bytes,
					  ObjectUtils
					   .asMap("folder", FOLDER_NAME, "use_filename", true))
					   .get("secure_url");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public String upload(String url) {

		try {
			
			return (String) cloudinary.uploader()
					.upload(
					  url,
					  ObjectUtils
					   .asMap("folder", FOLDER_NAME, "use_filename", true))
					   .get("secure_url");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	public Boolean delete(String publicId) {

		try {

			if(StringUtils.hasText(publicId)) {
				
				cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
			}

			return true;

		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}

	}

	public String getPublicId(String url) {

		String [] split = url.split("/");
		
		
		if(!Pattern.compile("([^\\s]+(\\.(?i)(jpeg|png|jpg))$)").matcher(url).matches()) {
			
			return "";
			
		}
		
		
		return FOLDER_NAME + "/" + split[split.length - 1].split("\\.")[0];
		
	}
	
}
