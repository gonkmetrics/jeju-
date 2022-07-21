package io.jejuwn.model;


import java.math.BigDecimal;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_order")
@Entity(name="UserOrder")
public class UserOrder {
  
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ORD_SEQ")
	@SequenceGenerator(sequenceName = "user_ord_seq", allocationSize = 1, name = "USER_ORD_SEQ")
	@Id
    private Long id;
	@Column
    private Long token;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Usertbl.class)
	@JoinColumn(name="user_id")
    private Long userId;
	@Column
    private Long cartId;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Address.class)
	@JoinColumn(name="address_id")
    private Long addressId;
	@Column
    private Long status;
	@Column
    private Long promotionId;
	@Column
	private String impUid;
    
}