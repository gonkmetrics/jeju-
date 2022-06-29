package io.jejuwn.persistence;

import lombok.Data;

@Data
public class UserVO {
	private Long uId;
	private String name;
	private String nick;
	private String pass;
	private int gender;
	private int phone;
	private int age;
	private String email;
	private int role;
}
