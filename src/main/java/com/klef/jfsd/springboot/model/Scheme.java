package com.klef.jfsd.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="schemetable")
public class Scheme 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="scheme_id")
    private int id;

    @Column(name = "scheme_name", nullable = false)
    private String name;

    @Column(name = "scheme_description", nullable = false)
    private String description;

    @Column(name = "scheme_deadline", nullable = false)
    private LocalDate deadline;

    @Column(name = "eligibility_criteria", nullable = false)
    private String eligibilityCriteria;

   

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}

	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	
}
