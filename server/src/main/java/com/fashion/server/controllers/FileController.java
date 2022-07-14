package com.fashion.server.controllers;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import com.fashion.server.cloudinary.CloudinaryHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/file")
public class FileController {

	@Autowired
	private CloudinaryHandle cloudinaryHandle;
	
	
	@Operation(summary = "upload image")
	@ApiResponses(value = {
	  @ApiResponse(
	    responseCode = "200", description = "successful operation",
	    content = {
		 @Content(mediaType = "application/json",
				 schema = @Schema(implementation = String.class))
	    }),
	  @ApiResponse(responseCode = "404", description = "Not found"),
	  @ApiResponse(responseCode = "500", description = "Internal server error"),
	})
	@PostMapping(produces = {"application/json"},consumes = { "multipart/form-data" })
	private ResponseEntity<?>upload(
		@Parameter(description = "",required = true)
		 @RequestPart(name = "file") @NotNull MultipartFile file
		) throws IOException {
		
		return ResponseEntity.ok(cloudinaryHandle.upload(file.getBytes()));
		
	}
	
}
