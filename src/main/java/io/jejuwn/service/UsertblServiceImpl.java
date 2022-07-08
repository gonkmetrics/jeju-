package io.jejuwn.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jejuwn.mapper.UsertblMapper;
import io.jejuwn.model.Usertbl;
import io.jejuwn.repository.UserRepository;

@Service
public class UsertblServiceImpl implements UsertblService {
	
	@Autowired
	private UsertblMapper mapper;
	
	@Autowired
	UserRepository userRepository;
	
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
	
	@Override
	public Optional<Usertbl> findByIdPw(Long id) { return userRepository.findById(BigDecimal.valueOf(id)); }
	// i love my repository
	// where is my repository
	/*
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠛⢻⣿⣯⣿⣿⣿⣶⣶⣶⣶⣤⣤⣤⣀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⢨⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠈⠻⣿⡛⠉⠭⠉⠉⢉⣿⣿⣧⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠈⠙⠲⣶⠖⠄⠄⢿⣿⠄⠶⣶⣾⣿⣿⣿⣿⣧⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠈⠄⠄⠄⠺⢿⡗⠄⣹⣿⣿⠿⣟⣿⡏⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠤⠤⢾⣿⣿⣿⣦⠘⡿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠈⢻⡿⣷⣶⣶⣤⣤⣤⣶⣦⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⣽⣿⣿⣿⣿⣿⣿⣿⣿⡟⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⠘⠿⣿⣿⣿⣿⣿⣿⣿⠃⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 *  ⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠉⠉⠛⠋⠉⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄
	 * 
	 */
}
