package io.jejuwn.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jejuwn.model.ProductLike;

@Repository
public interface ProductLikeRepository extends JpaRepository<ProductLike, BigDecimal> {

}
