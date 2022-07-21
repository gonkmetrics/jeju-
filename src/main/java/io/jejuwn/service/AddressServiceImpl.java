package io.jejuwn.service;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import io.jejuwn.model.Address;
import io.jejuwn.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	
	@Autowired
	private AddressRepository repository;
	
	@Override
	public List<Address> getAddressList() {
		return repository.findAll();
	}
	
	@Override
	public void addressInsert(Address vo) {
		repository.save(vo);
	}
	
	@Override
	public void addressDelete(Long id) {
		repository.deleteById(id);
	}
	
	@Override
	public void addressUpdate(Address vo) {
		repository.save(vo);
	}
	
	@Override
	public Address addressDetail(Long userId) {
		Address addressDetail = repository.findById(userId).get();
		return addressDetail;
	}

}
