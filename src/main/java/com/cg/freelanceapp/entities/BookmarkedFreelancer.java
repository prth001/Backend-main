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
import jakarta.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BookmarkedFreelancer implements Serializable {

	private static final long serialVersionUID = 9145091598260400574L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "bkd_fr_seq")
	@SequenceGenerator(name = "bkd_fr_seq", sequenceName = "bkd_fr_seq", allocationSize = 1)
	@Column(name = "bkd_fr_id", updatable = false)
	private Long id;

	@OneToOne(targetEntity = Freelancer.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH })
	@JoinColumn(name = "freelancer_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Freelancer freelancer;

	@ManyToOne(targetEntity = Recruiter.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.DETACH })
	@JoinColumn(name = "recruiter_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Recruiter bookmarkedBy;

	public BookmarkedFreelancer() {
		super();
	}

	public BookmarkedFreelancer(@NotNull(message = "Freelancer id should not be empty.") Freelancer freelancer,
			@NotNull(message = "Recruiter id should not be empty.") Recruiter bookmarkedBy) {
		super();
		this.freelancer = freelancer;
		this.bookmarkedBy = bookmarkedBy;
	}

	public Recruiter getBookmarkedBy() {
		return bookmarkedBy;
	}

	public Freelancer getFreelancer() {
		return freelancer;
	}

	public Long getId() {
		return id;
	}

	public void setBookmarkedBy(Recruiter bookmarkedBy) {
		this.bookmarkedBy = bookmarkedBy;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
