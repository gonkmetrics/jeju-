package io.jejuwn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jejuwn.persistence.CartItemVO;
import io.jejuwn.service.CartItemService;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/cartitem")
public class CartItemController {
		
	
	@Autowired
	private CartItemService service;
	
		// insert
		@PostMapping(value="", consumes="application/json",
								produces= {MediaType.TEXT_PLAIN_VALUE})
				public ResponseEntity<String> insert(
					@RequestBody CartItemVO vo){
				
				ResponseEntity<String> entity = null;
				try {
					service.carItemInsert(vo);
					entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
				} catch(Exception e) {
					entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
				return entity;
	}
	
		// delete
		@DeleteMapping(value="/{id}",
						produces = {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> delete(
						@PathVariable("id") Long id) {
				ResponseEntity<String> entity = null;
				
				try {
					
					service.cartItemDelete(id);
					entity = new ResponseEntity<String>(
							"SUCCESS", HttpStatus.OK);
				} catch(Exception e) {
					entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
				}
				return entity;
				}
}
