package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.ProductInfo;
import io.jejuwn.model.Usertbl;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long>{

}
