package io.jejuwn.service;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.AddressMapper;
import io.jejuwn.model.Address;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressMapper mapper;
	
	@Override
	public List<Address> getAddressList() {
		return mapper.selectByExample(null);
	}
	
	@Override
	public void addressInsert(Address vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void addressDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
	}
	
	@Override
	public void addressUpdate(Address vo) {
		mapper.updateByPrimaryKey(vo);
	}
	
	@Override
	public Address addressDetail(Long id) {
		Address addressDetail = mapper.selectByPrimaryKey(BigDecimal.valueOf(id));
		return addressDetail;
	}



}
