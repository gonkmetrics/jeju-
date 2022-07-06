package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.UsertblMapper;
import io.jejuwn.model.Usertbl;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UsertblMapper mapper;
	
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
	
	public void updateUser(Usertbl vo) {
		mapper.updateByPrimaryKey(vo);
	}

}
