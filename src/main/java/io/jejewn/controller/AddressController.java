package io.jejewn.controller;

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

import io.jejewn.persistence.AddressVO;
import io.jejewn.service.AddressService;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@PostMapping(value="", consumes="application/json",
							produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insert(
			@RequestBody AddressVO vo){
		
		ResponseEntity<String> entity = null;
		try {
			service.addressInsert(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@DeleteMapping(value="/{addId}",
							produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String>  delete(
			@PathVariable("addId") Long addId) {
				ResponseEntity<String> entity = null;
				
				try {
					
					service.addressDelete(addId);
					entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
				} catch(Exception e) {
					entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
				}
				return entity;
			}

}
