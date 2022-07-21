package io.jejuwn.model;


import lombok.Data;

@Data
public class PaymentRequest {
	//private Long id;
	private Long token;
	private Long userId;
	private Long cartId;
	private Long addressId;
	private Long status;
	private Long promotionId;
	private String impUid;
	

}
