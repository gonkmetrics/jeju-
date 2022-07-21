package io.jejuwn.model;


import java.util.Date;

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
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="blog_user_test")
@Entity(name="BlogUserTest")
public class BlogUserTest {
   
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERTBL_SEQ")
	@SequenceGenerator(sequenceName = "usertbl_seq", allocationSize = 1, name = "USERTBL_SEQ")
	@Id
    private Long id;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Usertbl.class)
	@JoinColumn(name="user_id")
    private Long userId;
	@Column
    private String title;
	@Column
    private String content;
	@Column
    private Date regdate;
	@Column
    private Date updatedate;
}