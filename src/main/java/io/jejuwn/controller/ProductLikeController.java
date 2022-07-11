package io.jejuwn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.jejuwn.model.ProductLike;
import io.jejuwn.service.ProductLikeService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/productlike")
public class ProductLikeController {
		
		@Autowired
		private ProductLikeService service;
		
		// insert
		@PostMapping(value="", consumes="application/json",
								produces= {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> insert(
				@RequestBody ProductLike vo){
			
			ResponseEntity<String> entity = null;
			try {
				service.productLikeInsert(vo);
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			} catch(Exception e) {
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return entity;
		}
		
		// delete
		@DeleteMapping(value="/{id}",
								produces = {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String>  delete(
				@PathVariable("id") Long id) {
					ResponseEntity<String> entity = null;
					
					try {
						
						service.productLikeDelete(id);
						entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
					} catch(Exception e) {
						entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
					}
					return entity;
				}
		// 내 찜목록 불러오는 메서드
		@GetMapping(value="/list/{userId}",
				produces= {MediaType.APPLICATION_XML_VALUE,
							MediaType.APPLICATION_JSON_UTF8_VALUE})
		public ResponseEntity<List<ProductLike>> list (
				@PathVariable("userId") Long userId) {
			
				ResponseEntity<List<ProductLike>> entity = null;
				
				try {
					entity = new ResponseEntity<>(
							service.getProductLikeList(userId), HttpStatus.OK);			
				} catch(Exception e) {
					e.printStackTrace();
					entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
				return entity;
				}
		
}
