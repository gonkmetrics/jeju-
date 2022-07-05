package io.jejuwn.service;

import java.math.BigDecimal;
<<<<<<< HEAD

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
>>>>>>> origin/merge_prep
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.AddressMapper;
import io.jejuwn.model.Address;

@Service
<<<<<<< HEAD
=======
@Component
>>>>>>> origin/merge_prep
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
<<<<<<< HEAD
	public void addressDelete(Long id) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
=======
	public void addressDelete(Long addId) {
		mapper.deleteByPrimaryKey(BigDecimal.valueOf(addId));
>>>>>>> origin/merge_prep
	}
	
	@Override
	public void addressUpdate(Address vo) {
		mapper.updateByPrimaryKey(vo);
	}
	
	@Override
<<<<<<< HEAD
	public Address addressDetail(Long userId) {
		Address addressDetail = mapper.selectByPrimaryKey(BigDecimal.valueOf(userId));
		return addressDetail;
	}

=======
	public Address addressDetail(Long addId) {
		Address addressDetail = mapper.selectByPrimaryKey(BigDecimal.valueOf(addId));
		return addressDetail;
	}



>>>>>>> origin/merge_prep
}
