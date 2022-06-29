package io.jejuwn.persistence;

import lombok.Data;

@Data
public class AddressVO {
	
	private Long addId;
	private Long user_id;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postalCode;
	private int phone;

}
