package io.jejuwn.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.Product;

public interface ProductRepository extends JpaRepository<Product, BigDecimal> {
}
