package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.Promotion;
import io.jejuwn.model.Usertbl;

public interface PromotionRepository extends JpaRepository<Promotion, Long>{

}
