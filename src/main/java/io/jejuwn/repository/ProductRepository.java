package io.jejuwn.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jejuwn.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigDecimal> {
	
	List<Product> findAll();
}
