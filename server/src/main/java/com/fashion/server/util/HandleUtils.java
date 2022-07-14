package com.fashion.server.util;

import java.lang.reflect.Field;
import java.text.Normalizer;
import java.util.Optional;

public class HandleUtils {

	public static String generateSlug(String name) {	
		return  Normalizer.normalize(name, Normalizer.Form.NFD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
				.toLowerCase()
				.replaceAll("đ", "d")
				.replaceAll(" ", "-");
	}
	

	public static Object mergeEntity(Object a, Object b) {

		try {

			for (Field field_a : a.getClass().getDeclaredFields()) {
				
				field_a.setAccessible(true);
				
				Optional<?> obj = Optional.ofNullable(field_a.get(a));

				if (obj.isPresent()) {
					Field field_b = b.getClass().getDeclaredField(field_a.getName());
					field_b.setAccessible(true);
					field_b.set(b, obj.get());
					field_b.setAccessible(false);
				}
				
				field_a.setAccessible(false);

			}


		} catch (NoSuchFieldException | SecurityException 
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	
}
