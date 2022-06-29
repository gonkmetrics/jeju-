package io.jejuwn.persistence;

import lombok.Data;

@Data
public class CartVO {
	private Long cId;
	private int token;
	private Long userId;
}
