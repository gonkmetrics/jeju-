package io.jejewn.persistence;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class ReservationVO {
	
	private Long rId;
	private String name;
	private Date regDate;
	private Long userId;
	private Long reservation;
	private Long status;
	private Long pId;
		
	
	/*
	create table reservation (
    id number(38,0),
    name varchar2(200) not null,
    regdate date default sysdate,
    user_id number(38,0),
    reservation number(38,0),
    status number(38,0),
    product_id number(38,0),
    PRIMARY KEY(id),
    FOREIGN KEY(product_id) REFERENCES product(id),
    FOREIGN KEY(user_id) REFERENCES usertbl(id)
    */
}
