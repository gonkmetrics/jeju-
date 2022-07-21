package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.ProductLike;
import io.jejuwn.model.Usertbl;

public interface ProductLikeRepository extends JpaRepository<ProductLike, Long>{

}
