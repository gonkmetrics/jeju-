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
@Table(name="likestat")
@Entity(name="likestat")
public class LikeStat {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stat_seq")
	@SequenceGenerator(sequenceName = "stat_seq", allocationSize = 1, name = "stat_seq")
	@Id
    private Long id;
	@Column
	private String location;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=Product.class)
	@JoinColumn(name="like_count")
	private int likeCount;

}
