package io.jejuwn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jejuwn.model.LikeStat;
import io.jejuwn.service.LikeStatService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/likestat")
public class LikeStatController {
	
	@Autowired
	private LikeStatService service;
	
	@GetMapping(value="/list",
			produces= {MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<LikeStat>> list() {
		ResponseEntity<List<LikeStat>> entity = null;
	
	try {
		entity = new ResponseEntity<>(service.getAllLikeStatList(), HttpStatus.OK);
	} catch(Exception e) {
		e.printStackTrace();
		entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	return entity;
}

}
