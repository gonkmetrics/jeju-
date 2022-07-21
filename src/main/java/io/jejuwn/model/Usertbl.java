package io.jejuwn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@ToString
@Entity(name="usertbl")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="Usertbl")
@Embeddable
public class Usertbl implements Serializable{
  
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERTBL_SEQ")
	@SequenceGenerator(sequenceName = "usertbl_seq", allocationSize = 1, name = "USERTBL_SEQ")
	@Id
    private Long id;

	@Column
    private String name;

    @Column(name = "nick")
    private String nick;

	@Column(name = "pass")
    private String pass;

	@Column
    private Long gender;

	@Column
    private Long age;

	@Column
    private String email;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @Singular
    private final Collection<Role> roles = new ArrayList();
    
    


    
}