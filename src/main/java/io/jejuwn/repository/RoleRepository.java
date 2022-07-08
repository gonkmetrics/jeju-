package io.jejuwn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jejuwn.model.Role;
import io.jejuwn.model.RoleSet;
import io.jejuwn.model.Usertbl;

// @Repository
public interface RoleRepository extends JpaRepository<Usertbl, Long>{
	// Optional<Role> findByName(RoleSet name);
}
