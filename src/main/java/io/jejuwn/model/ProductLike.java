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
@Table(name="product_like")
@Entity(name="ProductLike")
public class ProductLike {
   
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_LIK_SEQ")
	@SequenceGenerator(sequenceName = "product_lik_seq", allocationSize = 1, name = "PRODUCT_LIK_SEQ")
	@Id
    private Long id;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Usertbl.class)
	@JoinColumn(name="user_id")
    private Long userId;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Product.class)
	@JoinColumn(name="product_id")
    private Long productId;
    
}