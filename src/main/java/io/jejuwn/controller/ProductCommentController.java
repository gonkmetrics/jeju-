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
import org.springframework.web.bind.annotation.RestController;

import io.jejuwn.persistence.ProductCommentVO;
import io.jejuwn.service.ProductCommentService;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/pcomment")
public class ProductCommentController {
	
	@Autowired
	private ProductCommentService service;
	
	// insert
	@PostMapping(value="", consumes="application/json",
							produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insert(
			@RequestBody ProductCommentVO vo){
		
		ResponseEntity<String> entity = null;
		try {
			service.insertProductComment(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 특정 글의 댓글을 불러오는 메서드
	@GetMapping(value="/all/{pId}",
			produces= {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ProductCommentVO>> list (
			@PathVariable("pId") Long pId) {
		
			ResponseEntity<List<ProductCommentVO>> entity = null;
			
			try {
				entity = new ResponseEntity<>(
						service.getProductCommentList(pId), HttpStatus.OK);			
			} catch(Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return entity;
			}
	
	// delete
	@DeleteMapping(value="/{pcId}",
					produces = {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> delete(
				@PathVariable("pcId") Long pcId) {
		ResponseEntity<String> entity = null;
		
		try {
			
			service.deleteProdcutComment(pcId);
			entity = new ResponseEntity<String>(
					"SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
		}
	
	// update
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
					value="/{pcId}",
					consumes="application/json",
					produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update (
			@RequestBody ProductCommentVO vo,
			@PathVariable("pcId") Long pcId){
		
		ResponseEntity<String> entity = null;
		try {
			vo.setPcId(pcId);
			service.updateProductComment(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
