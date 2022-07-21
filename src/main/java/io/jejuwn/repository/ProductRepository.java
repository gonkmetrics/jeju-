package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}
