package io.jejuwn.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jejuwn.model.Usertbl;

@Repository
public interface UserRepository extends JpaRepository<Usertbl, BigDecimal>{
	Optional<Usertbl> findById(BigDecimal userid);
	Optional<Usertbl> findByNick(String nick);
	// Boolean existsByUsername(String username);
	
	//shoulda just used spring roo

}
