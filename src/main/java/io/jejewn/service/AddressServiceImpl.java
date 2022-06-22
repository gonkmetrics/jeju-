package io.jejewn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejewn.mapper.AddressMapper;
import io.jejewn.persistence.AddressVO;

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
