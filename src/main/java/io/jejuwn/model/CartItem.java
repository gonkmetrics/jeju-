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
@Table(name="cart_item")
@Entity(name="CartItem")
public class CartItem {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CART_ITEM_SEQ")
	@SequenceGenerator(sequenceName = "cart_item_seq", allocationSize = 1, name = "CART_ITEM_SEQ")
	@Id
    private Long id;
	@Column
    private Long item;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Product.class)
	@JoinColumn(name="cart_id")
    private Long cartId;
	@Column
    private Long productId;
	@Column
    private Long category;
	@Column
	private Long quantity;
	@Column
	private Long price;

    
}