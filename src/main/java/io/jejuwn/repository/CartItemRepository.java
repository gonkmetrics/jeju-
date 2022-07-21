package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.CartItem;
import io.jejuwn.model.Usertbl;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
