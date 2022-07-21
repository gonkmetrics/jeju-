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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_comment")
@Entity(name="ProductComment")
public class ProductComment {
   
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_COM_SEQ")
	@SequenceGenerator(sequenceName = "product_com_seq", allocationSize = 1, name = "PRODUCT_COM_SEQ")
	@Id
    private Long id;
	@Column
    private String content;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Usertbl.class)
	@JoinColumn(name="user_id")
    private Long userId;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Product.class)
	@JoinColumn(name="product_id")
    private Long productId;
	@Column
    private Date regdate;
	@Column
    private Date updatedate;
	@Column
    private Long rating;
    
}