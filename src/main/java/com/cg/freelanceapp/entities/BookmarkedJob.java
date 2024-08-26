package com.cg.freelanceapp.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BookmarkedJob implements Serializable {

	private static final long serialVersionUID = 216468327513376764L;

	@Id
	@Column(name = "bkd_job_id", updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "bkd_job_seq")
	@SequenceGenerator(name = "bkd_job_seq", sequenceName = "bkd_job_seq", allocationSize = 1)
	private Long id;

	@OneToOne(targetEntity = Skill.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "skill_id")
	private Skill skill;

	@ManyToOne(targetEntity = Job.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "job_id")
	private Job job;

	@OneToOne(targetEntity = Freelancer.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumn(name = "freelancer_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Freelancer freelancer;

	public BookmarkedJob() {
		super();
	}

	public BookmarkedJob(Skill skill, Job job, Freelancer freelancer) {
		super();
		this.skill = skill;
		this.job = job;
		this.freelancer = freelancer;
	}

	public Freelancer getFreelancer() {
		return freelancer;
	}

	public Long getId() {
		return id;
	}

	public Job getJob() {
		return job;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
