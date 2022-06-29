package io.jejuwn.persistence;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductCommentVO {
		
		private Long pcId;
		private String content;
		private Long uId;
		private Long pId;
		private int rating;
		private Date regdate;
		private Date updateDate;
}
