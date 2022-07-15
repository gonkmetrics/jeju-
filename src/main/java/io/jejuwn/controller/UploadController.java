package io.jejuwn.controller;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.jejuwn.model.Address;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/files")
public class UploadController {
	
	@PostMapping("/upload")
	public ResponseEntity<?> fileUpload(
	@RequestParam("file") MultipartFile file){
		
		String fileName = file.getOriginalFilename();
		try {
			file.transferTo(new File("C:\\upload\\" + fileName));
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	return ResponseEntity.ok("File uploaded successfully");
	}
}
