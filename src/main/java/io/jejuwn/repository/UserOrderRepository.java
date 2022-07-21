package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.UserOrder;
import io.jejuwn.model.Usertbl;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long>{

}
