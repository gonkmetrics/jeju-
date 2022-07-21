package io.jejuwn.model;

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
@Table(name="cart")
@Entity(name="Cart")
public class Cart {
   
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_SEQ")
	@SequenceGenerator(sequenceName = "cart_seq", allocationSize = 1, name = "CART_SEQ")
	@Id
    private Long id;
	@Column
    private Long token;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity=Usertbl.class)
	@JoinColumn(name="user_id")
    private Long userId;

}