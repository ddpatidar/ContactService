package com.contactbook.contactlist.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contact")
@Getter
@Setter
@ToString
public class Contact {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
}
