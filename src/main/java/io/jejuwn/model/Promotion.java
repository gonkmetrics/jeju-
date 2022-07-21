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
@Table(name="promotion")
@Entity(name="Promotion")
public class Promotion {
 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROMOTION_SEQ")
	@SequenceGenerator(sequenceName = "promotion_seq", allocationSize = 1, name = "PROMOTION_SEQ")
	@Id
    private Long id;
	@Column
    private String code;
	@Column
    private Long promotionValue;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Product.class)
	@JoinColumn(name="product_id")
    private Long productId;

}