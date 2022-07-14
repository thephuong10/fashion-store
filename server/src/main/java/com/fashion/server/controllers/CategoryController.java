package com.fashion.server.controllers;

import com.fashion.server.models.CategoryModel;
import com.fashion.server.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;
	
	@Operation(summary = "Save a category")
	@ApiResponses(value = {
	  @ApiResponse(
	    responseCode = "200", description = "successful operation",
	    content = {
		 @Content(
		  mediaType = "application/json",
		  schema = @Schema(implementation = CategoryModel.class))
	    }),
	  @ApiResponse(responseCode = "401", description = "Unauthenticated"),
	  @ApiResponse(responseCode = "403", description = "Access is denied"),
	  @ApiResponse(responseCode = "404", description = "Not found"),
	  @ApiResponse(responseCode = "500", description = "Internal server error"),
	})
	@PostMapping
	public ResponseEntity<?> create(
	    @RequestBody CategoryModel category
	) {
		
		return ResponseEntity.ok(iCategoryService.create(category));
		
	}
	
	@Operation(summary = "get all category")
	@ApiResponses(value = {
	  @ApiResponse(
	    responseCode = "200", description = "successful operation",
	    content = {
		 @Content(mediaType = "application/json",
				 array = @ArraySchema(schema = @Schema(implementation = CategoryModel.class)))
	    }),
	  @ApiResponse(responseCode = "404", description = "Not found"),
	  @ApiResponse(responseCode = "500", description = "Internal server error"),
	})
	@GetMapping("/get/all")
	public ResponseEntity<?>getAll() {
		
		return ResponseEntity.ok(iCategoryService.getAll());
		
	}
	
}
