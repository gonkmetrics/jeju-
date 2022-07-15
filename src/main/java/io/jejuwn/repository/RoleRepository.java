package io.jejuwn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jejuwn.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findById(Long id);
	Optional<Role> findByName(String name);

}
