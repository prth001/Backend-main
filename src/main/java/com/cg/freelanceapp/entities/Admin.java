package com.cg.freelanceapp.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Admin implements Serializable {

	private static final long serialVersionUID = -3376723589710738177L;

	@Id
	@Column(name = "admin_id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "admin_seq")
	@SequenceGenerator(name = "admin_seq", sequenceName = "admin_seq", allocationSize = 1)
	private Long id;
	@Column(unique = true, nullable = false)
	private String userName;
	@Column(nullable = false)
	private String firstName;
	private String lastName;
	@Column(nullable = false)
	private String password;

	public Admin() {
		super();
	}

	public Admin(String userName, String firstName, String lastName, String password) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}