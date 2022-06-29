package io.jejuwn.persistence;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProductInfoVO {
		
	private Long piId;
	private Long pId;
	private String content;
	private String contentExtra;
	private Date regdate;
	private Date updateDate;
	private Timestamp startTime;
	private Timestamp endTime;
	private int price;
	private int maxCapacity;
	private String address;
}
