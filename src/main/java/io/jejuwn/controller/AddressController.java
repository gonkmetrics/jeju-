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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.jejuwn.persistence.AddressVO;
import io.jejuwn.service.AddressService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	// insert
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
	// update
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
					value="/{addId}",
					consumes="application/json",
					produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update (
			@RequestBody AddressVO vo,
			@PathVariable("addId") Long addId){
		
		ResponseEntity<String> entity = null;
		try {
			vo.setAddId(addId);
			service.addressUpdate(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	// delete
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
	// address 전체를 가져오는 메서드
	@GetMapping(value="/list",
				produces= {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<AddressVO>> list() {
		ResponseEntity<List<AddressVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.getAddressList(), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	// 특정 address만 보는 메서드
	@GetMapping(value="/detail/{addId}",
				produces= {MediaType.APPLICATION_XML_VALUE,
							MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<AddressVO> detail (
			@PathVariable("addId") Long addId) {
			
		ResponseEntity<AddressVO> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.addressDetail(addId), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
