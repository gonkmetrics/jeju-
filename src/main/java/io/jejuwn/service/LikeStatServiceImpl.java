package io.jejuwn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.model.LikeStat;
import io.jejuwn.repository.LikeStatRepository;

@Service
public class LikeStatServiceImpl {
	
	@Autowired
	private LikeStatRepository repository;
	
	
	public List<LikeStat> getAllLikeStatList() {
		return repository.findAll();
	}

}
