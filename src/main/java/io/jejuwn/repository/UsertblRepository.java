package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.jejuwn.model.Usertbl;

@Repository
public interface UsertblRepository extends JpaRepository<Usertbl, Integer> {

}
