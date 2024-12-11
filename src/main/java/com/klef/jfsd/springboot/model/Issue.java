package com.klef.jfsd.springboot.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="issuetable")
public class Issue 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="issue_id")
    private int id;

    @Column(name="issue_description", nullable=false, length = 255)
    private String description;

    @Column(name="issue_status", nullable=false, length = 20)
    private String status = "Open"; // Default status

    @Column(name="issue_created_at", nullable=false)
    private LocalDateTime createdAt;
    
    @Column(name="issue_constituency", nullable=false, length = 100)
    private String constituency;
    
    @Column(name="issue_image_url", nullable=false)
    private String image_url;
    
    @ManyToOne
    @JoinColumn(name="citizen", nullable=false)
    private Citizen citizen; // Citizen who uploaded the issue

    @ManyToOne
    @JoinColumn(name="politician_id", nullable=true) // Initially null, set when a politician takes it
    private Politician politician;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Politician getPolitician() {
		return politician;
	}

	public void setPolitician(Politician politician) {
		this.politician = politician;
	} 

}
