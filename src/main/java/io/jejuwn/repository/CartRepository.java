package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.Cart;
import io.jejuwn.model.Usertbl;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
