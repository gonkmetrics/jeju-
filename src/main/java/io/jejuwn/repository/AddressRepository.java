package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.Address;
import io.jejuwn.model.Usertbl;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
