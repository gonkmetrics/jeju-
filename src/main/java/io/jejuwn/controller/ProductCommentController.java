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

import io.jejuwn.model.ProductComment;
import io.jejuwn.service.ProductCommentService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/pcomment")
public class ProductCommentController {
	
	@Autowired
	private ProductCommentService service;
	
	// insert
	@PostMapping(value="", consumes="application/json",
							produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insert(
			@RequestBody ProductComment vo){
		
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
<<<<<<< HEAD
	@GetMapping(value="/all/{productId}",
			produces= {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ProductComment>> list (
			@PathVariable("productId") Long productId) {
=======
	@GetMapping(value="/all/{pId}",
			produces= {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ProductComment>> list (
			@PathVariable("pId") Long pId) {
>>>>>>> origin/merge_prep
		
			ResponseEntity<List<ProductComment>> entity = null;
			
			try {
				entity = new ResponseEntity<>(
<<<<<<< HEAD
						service.getProductCommentList(productId), HttpStatus.OK);			
=======
						service.getProductCommentList(pId), HttpStatus.OK);			
>>>>>>> origin/merge_prep
			} catch(Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			return entity;
			}
	
	// delete
<<<<<<< HEAD
	@DeleteMapping(value="/{id}",
					produces = {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> delete(
				@PathVariable("id") Long id) {
=======
	@DeleteMapping(value="/{pcId}",
					produces = {MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<String> delete(
				@PathVariable("pcId") Long pcId) {
>>>>>>> origin/merge_prep
		ResponseEntity<String> entity = null;
		
		try {
			
<<<<<<< HEAD
			service.deleteProdcutComment(id);
=======
			service.deleteProdcutComment(pcId);
>>>>>>> origin/merge_prep
			entity = new ResponseEntity<String>(
					"SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
		}
	
	// update
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
<<<<<<< HEAD
					value="/{id}",
=======
					value="/{pcId}",
>>>>>>> origin/merge_prep
					consumes="application/json",
					produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update (
			@RequestBody ProductComment vo,
<<<<<<< HEAD
			@PathVariable("id") Long id){
		
		ResponseEntity<String> entity = null;
		try {
			vo.setProductId(BigDecimal.valueOf(id));
=======
			@PathVariable("pcId") Long pcId){
		
		ResponseEntity<String> entity = null;
		try {
			vo.setProductId(BigDecimal.valueOf(pcId));
>>>>>>> origin/merge_prep
			service.updateProductComment(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
