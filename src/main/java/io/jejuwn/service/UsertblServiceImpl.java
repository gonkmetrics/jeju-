package io.jejuwn.service;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.UsertblMapper;
import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.UsertblRepository;

@Service
public class UsertblServiceImpl implements UsertblService {
	
	@Autowired
	private UsertblMapper mapper;
	
	@Autowired
	private UsertblRepository userRepository;
	
	@Override
	public List<Usertbl> listUser() {
		return mapper.selectByExample(null);
	}
	
	@Override
	public void insertUser(Usertbl vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void deleteUser(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	
	@Override
	public Usertbl userDetail(Long id) {
		return mapper.selectByPrimaryKey(BigDecimal.valueOf(id));
	}
	@Override
	public void updateUser(Usertbl vo) {
		mapper.updateByPrimaryKey(vo);
	}
	
	public Page<Usertbl> userList(int page){
		PageRequest pageable = PageRequest.of(page, 10);
		return userRepository.findAll(pageable);
	}

}
