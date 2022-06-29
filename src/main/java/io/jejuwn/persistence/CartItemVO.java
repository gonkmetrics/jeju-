package io.jejuwn.persistence;

import lombok.Data;

@Data
public class CartItemVO {
	private Long ciId;
	private int item;
	private Long cId;
	private Long pId;
}
