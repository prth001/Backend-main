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
public class Skill implements Serializable {

	private static final long serialVersionUID = 8190256392493481389L;
	@Id
	@Column(name = "skill_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "skill_seq")
	@SequenceGenerator(name = "skill_seq", sequenceName = "skill_seq", allocationSize = 1)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	private String description;

	public Skill() {
		super();
	}

	public Skill(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
