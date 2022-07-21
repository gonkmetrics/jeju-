package io.jejuwn.controller;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jejuwn.model.ProductTraffic;
import io.jejuwn.service.ProductTrafficService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/producttraffic")
public class ProductTrafficController {
	
	@Autowired
	private ProductTrafficService service;
	
	// insert
	@PostMapping(value="", consumes="application/json",
							produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insert(
			@RequestBody ProductTraffic vo){
		
		ResponseEntity<String> entity = null;
		try {
			service.productTrafficInsert(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	// update
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
					value="/{id}",
					consumes="application/json",
					produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update (
			@RequestBody ProductTraffic vo,
			@PathVariable("id") Long id){
		
		ResponseEntity<String> entity = null;
		try {
			vo.setId(id);
			service.productTrafficUpdate(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
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
					
					service.productTrafficDelete(id);
					entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
				} catch(Exception e) {
					entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
				return entity;
			}
	// productTraffic 전체 리스트
	@GetMapping(value="/list",
				produces= {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ProductTraffic>> list() {
		ResponseEntity<List<ProductTraffic>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.getProductTrafficList(), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	// 특정 productTraffic만 보는 메서드
	@GetMapping(value="/detail/{id}",
				produces= {MediaType.APPLICATION_XML_VALUE,
							MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ProductTraffic> detail (
			@PathVariable("id") Long id) {
			
		ResponseEntity<ProductTraffic> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.productTrafficDetail(id), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
