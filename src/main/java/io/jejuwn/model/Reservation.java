package io.jejuwn.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="reservation")
@Entity(name="Reservation")
public class Reservation {
   
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVATION_SEQ")
	@SequenceGenerator(sequenceName = "reservation_seq", allocationSize = 1, name = "RESERVATION_SEQ")
	@Id
    private Long id;
	@Column
    private String name;
	@Column
    private Date regdate;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Usertbl.class)
	@JoinColumn(name="user_id")
    private Long userId;
	@Column
    private Long reservation;
	@Column
    private Date reservationDate;
	@Column
    private Long status;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Product.class)
	@JoinColumn(name="product_id")
    private Long productId;
    
}