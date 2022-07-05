package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.AddressMapper;
import io.jejuwn.model.Address;

@Service
@Component
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
	public void addressDelete(Long addId) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(addId));
	}
	
	@Override
	public void addressUpdate(Address vo) {
		mapper.updateByPrimaryKey(vo);
	}
	
	@Override
	public Address addressDetail(Long addId) {
		Address addressDetail = mapper.selectByPrimaryKey(BigDecimal.valueOf(addId));
		return addressDetail;
	}



}
