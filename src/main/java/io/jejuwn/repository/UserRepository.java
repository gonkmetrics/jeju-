package io.jejuwn.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jejuwn.model.Usertbl;

@Repository
public interface UserRepository extends JpaRepository<Usertbl, Long>{
	Optional<Usertbl> findById(Long id);
	Optional<Usertbl> findByNick(String nick);
	Optional<Usertbl> findByIdAndPass(Long id, String pass);
	// Boolean existsByUsername(String username);
	
	//shoulda just used spring roo

}
