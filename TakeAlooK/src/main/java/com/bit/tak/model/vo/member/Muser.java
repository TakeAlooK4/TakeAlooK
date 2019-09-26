package com.bit.tak.model.vo.member;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "muser")
public class Muser {
	
	@Id
	@Column(name = "nickname", length = 10)
	private String nickname;
	
	@NotNull(message = "id null")
	@Column(name = "id", unique = true, length = 25)
	private String id;
	
	@NotNull(message = "password null")
	@Column(name = "password", length = 150)
	private String password;
	
	@NotNull(message = "name null")
	@Column(name = "name", length = 10)
	private String name;
	
	@Column(name = "contact", length = 12)
	private String contact;
	
	
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "id")
//	private List<UserRole> roles;
	
}
