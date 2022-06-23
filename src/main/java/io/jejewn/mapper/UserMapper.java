package io.jejewn.mapper;

import java.util.List;

import io.jejewn.persistence.UserVO;

public interface UserMapper {
	
	public List<UserVO> getList();
	
	public void insert(UserVO vo);
	
	public void update(UserVO vo);
	
	public void delete(Long id);
	
	public UserVO userDetail(Long id);
}
