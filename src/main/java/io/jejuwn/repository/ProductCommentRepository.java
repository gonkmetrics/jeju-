package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.ProductComment;
import io.jejuwn.model.Usertbl;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long>{

}
