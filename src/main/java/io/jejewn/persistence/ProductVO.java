package io.jejewn.persistence;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class ProductVO {

	private Long pId;
	private String name;
	private String content;
	private Date regDate;
	private Date updateDate;
	private Timestamp startTime;
	private Timestamp endTime;
	private Long price;
	private Long hit;
	private Long maxCapacity;
	private String location;
	private Long userId;
	
	

	/* 
	create table product (
	    id number(38,0),
	    name varchar2(200) not null,
	    content varchar2(2000) not null,
	    regdate date default sysdate,
	    updatedate date default sysdate,
	    start_time timestamp(2),
	    end_time timestamp(2),
	    price number(38,0),
	    hit number(38,0),
	    max_capacity number(38,0),
	    location varchar2(1000) not null,
	    user_id number(38,0),
	    PRIMARY KEY(id),
	    FOREIGN KEY(user_id) REFERENCES usertbl(id)
	 */
}