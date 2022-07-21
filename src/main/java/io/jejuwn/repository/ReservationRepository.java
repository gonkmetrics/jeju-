package io.jejuwn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jejuwn.model.Reservation;
import io.jejuwn.model.Usertbl;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
