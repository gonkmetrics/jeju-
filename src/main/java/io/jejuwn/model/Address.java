package io.jejuwn.model;

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
@Table(name="address")
@Entity(name="Address")
public class Address {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
	@SequenceGenerator(sequenceName = "address_seq", allocationSize = 1, name = "ADDRESS_SEQ")
	@Id
    private Long id;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Usertbl.class)
	@JoinColumn(name="user_id")
    private Long userId;
	@Column
    private String addressLine1;
	@Column
    private String addressLine2;
	@Column
    private String city;
	@Column
    private String postalCode;
	@Column
    private String phone;

    
}