package io.jejuwn.repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jejuwn.model.Usertbl;

@Repository
public interface UsertblRepository extends JpaRepository<Usertbl, Integer> {

	Page<Usertbl> findAll(Pageable pageable);

}
