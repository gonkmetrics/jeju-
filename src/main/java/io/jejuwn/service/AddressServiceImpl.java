package io.jejuwn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.AddressMapper;
import io.jejuwn.persistence.AddressVO;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressMapper mapper;
	
	@Override
	public List<AddressVO> getAddressList() {
		return mapper.getAddressList();
	}
	
	@Override
	public void addressInsert(AddressVO vo) {
		mapper.insert(vo);
	}
	
	@Override
	public void addressDelete(Long addId) {
		mapper.delete(addId);
	}
	
	@Override
	public void addressUpdate(AddressVO vo) {
		mapper.update(vo);
	}
	
	@Override
	public AddressVO addressDetail(Long addId) {
		AddressVO addressDetail = mapper.addressDetail(addId);
		return addressDetail;
	}

}
