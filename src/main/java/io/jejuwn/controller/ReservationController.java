package io.jejuwn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jejuwn.model.Reservation;
import io.jejuwn.service.ReservationService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService service;
	
	// insert
	@PostMapping(value="", consumes="application/json",
							produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insert(
			@RequestBody Reservation vo){
		
		ResponseEntity<String> entity = null;
		try {
			service.ReservationInsert(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
