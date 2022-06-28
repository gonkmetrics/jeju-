package io.jejewn.persistence;

import lombok.Data;

@Data
public class AddressVO {
	
	private Long addId;
	private Long uId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postalCode;
	private int phone;

}
