package com.fashion.server.controllers;
import com.fashion.server.models.ProductModel;
import com.fashion.server.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private IProductService iProductService;
	
	
	@Operation(summary = "get all products by top selled")
	@ApiResponses(value = {
	  @ApiResponse(
	    responseCode = "200", description = "successful operation",
	    content = {
		 @Content(mediaType = "application/json",
				 array = @ArraySchema(schema = @Schema(implementation = ProductModel.class)))
	    }),
	  @ApiResponse(responseCode = "404", description = "Not found"),
	  @ApiResponse(responseCode = "500", description = "Internal server error"),
	})
	@GetMapping("/get/all/topSelled")
	public ResponseEntity<?>getAllByTopSelled(
			@Parameter(description = "Page want to go (start by 0)",required = true)
			  @RequestParam(name = "page") Integer page,
			@Parameter(description = "Total item on one page",required = true) 
			  @RequestParam(name = "limit") Integer limit
	) {
		
		return ResponseEntity
				.ok(iProductService
				 .getAll(PageRequest.of(page, limit,Sort.by("selled").descending())));
		
	}
	
	

	
	
	@Operation(summary = "get all products by category id")
	@ApiResponses(value = {
	  @ApiResponse(
	    responseCode = "200", description = "successful operation",
	    content = {
		 @Content(mediaType = "application/json",
				 array = @ArraySchema(schema = @Schema(implementation = ProductModel.class)))
	    }),
	  @ApiResponse(responseCode = "404", description = "Not found"),
	  @ApiResponse(responseCode = "500", description = "Internal server error"),
	})
	@GetMapping("/get/all/category/{categoryId}")
	public ResponseEntity<?>getAllByCategory(
			@Parameter(description = "Category id of foods",required = true)
			  @PathVariable(name = "categoryId") String categoryId,
			@Parameter(description = "Page want to go (start by 0)",required = true)
			  @RequestParam(name = "page") Integer page,
			@Parameter(description = "Total item on one page",required = true) 
			  @RequestParam(name = "limit") Integer limit
	) {


		return ResponseEntity
				.ok(iProductService
				 .getAllByCategoryId(categoryId,
					PageRequest.of(page, limit)));
		
	}
	
	
		
	
	@Operation(summary = "get all product by category id")
	@ApiResponses(value = {
	  @ApiResponse(
	    responseCode = "200", description = "successful operation",
	    content = {
		 @Content(mediaType = "application/json",
				 array = @ArraySchema(schema = @Schema(implementation = ProductModel.class)))
	    }),
	  @ApiResponse(responseCode = "404", description = "Not found"),
	  @ApiResponse(responseCode = "500", description = "Internal server error"),
	})
	@GetMapping("/get/{id}")
	public ResponseEntity<?>getOneById(
			@Parameter(description = "Id of product",required = true)
			  @PathVariable(name = "id") String id
	) {


		return ResponseEntity
				.ok(iProductService.getOneById(id));
		
	}
	
	
	
	@Operation(summary = "save a product")
	@ApiResponses(value = {
	  @ApiResponse(
	    responseCode = "200", description = "successful operation",
	    content = {
		 @Content(
		  mediaType = "application/json",
		  schema = @Schema(implementation = ProductModel.class))
	    }),
	  @ApiResponse(responseCode = "401", description = "Unauthenticated"),
	  @ApiResponse(responseCode = "403", description = "Access is denied"),
	  @ApiResponse(responseCode = "404", description = "Not found"),
	  @ApiResponse(responseCode = "500", description = "Internal server error"),
	})
	@PostMapping
	public ResponseEntity<?>create(
	  @Parameter(description = "data of product",required = true,
	  schema = @Schema(implementation = ProductModel.class)) 
	    @RequestBody ProductModel food
	) {
		
		return ResponseEntity.ok(iProductService.create(food));
		
	}
	
	@Operation(summary = "update a product")
	@ApiResponses(value = {
	  @ApiResponse(
	    responseCode = "200", description = "successful operation",
	    content = {
		 @Content(
		  mediaType = "application/json",
		  schema = @Schema(implementation = ProductModel.class))
	    }),
	  @ApiResponse(responseCode = "401", description = "Unauthenticated"),
	  @ApiResponse(responseCode = "403", description = "Access is denied"),
	  @ApiResponse(responseCode = "404", description = "Not found"),
	  @ApiResponse(responseCode = "500", description = "Internal server error"),
	})
	@PutMapping
	public ResponseEntity<?>update(
	  @Parameter(description = "data of product",required = true,
	  schema = @Schema(implementation = ProductModel.class)) 
	    @RequestBody ProductModel product
	) {

		return ResponseEntity.ok(iProductService.update(product));
		
	}
	
	
	
	
	
	
}
