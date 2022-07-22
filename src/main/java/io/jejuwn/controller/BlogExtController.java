package io.jejuwn.controller;

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

import io.jejuwn.mapper.BlogExtMapper;
import io.jejuwn.model.BlogUserTest;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/blog")
public class BlogExtController {
	
	@Autowired
	private BlogExtMapper blogExtMapper;
	
	@GetMapping(value="/table", 
				produces= {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> tableInsert(
				@PathVariable("id") int id){
		log.info("------------------------");
		ResponseEntity<String> entity = null;
		try {
			blogExtMapper.createBlogTable(id);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		}
	
	@PostMapping(value="", consumes="application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insert(
			 @RequestBody BlogUserTest vo){
	log.info("------------------------");
	ResponseEntity<String> entity = null;
	try {
		blogExtMapper.insertBlog(vo);
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
				@PathVariable("id") int id) {
		ResponseEntity<String> entity = null;
		
		try {
			blogExtMapper.deleteBlog(id);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
		}
	
	// update
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
					value="/{id}",
					consumes="application/json",
					produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update (
			@RequestBody BlogUserTest vo,
			@PathVariable("id") Long id){
		
		ResponseEntity<String> entity = null;
		try {
			vo.setId(id);
			blogExtMapper.updateBlog(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
