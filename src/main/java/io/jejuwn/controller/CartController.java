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

import io.jejuwn.model.Cart;
import io.jejuwn.service.CartService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService service;
	
	// insert
	@PostMapping(value="", consumes="application/json",
							produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insert(
			@RequestBody Cart vo){
		
		ResponseEntity<String> entity = null;
		try {
			service.cartInsert(vo);
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
					
					service.cartDelete(id);
					entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
				} catch(Exception e) {
					entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
				return entity;
			}
	// 카트 전체를 가져오는 메서드
	@GetMapping(value="/list",
				produces= {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Cart>> list() {
		ResponseEntity<List<Cart>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.getAllCartList(), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	// 한 유저의 장바구니 불러오는 메서드
	@GetMapping(value="/list/{userId}",
			produces= {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Cart> list (
			@PathVariable("userId") Long userId) {
		
			ResponseEntity<Cart> entity = null;
			
			try {
				entity = new ResponseEntity<>(
						service.getCart(userId), HttpStatus.OK);			
			} catch(Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return entity;
			}

}
