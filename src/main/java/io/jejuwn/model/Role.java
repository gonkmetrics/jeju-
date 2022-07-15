package io.jejuwn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	/*the getters are in the ligma class
	* what ligma class?
	* ligma balls dude U+1F602 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
	private Long id;
	private String name;
	public Role(String roleName) {
		this.name=roleName;
	}

}
