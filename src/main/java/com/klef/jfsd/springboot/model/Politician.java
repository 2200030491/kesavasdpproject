package com.klef.jfsd.springboot.model;

import org.eclipse.angus.mail.handlers.text_html;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="politiciantable")
public class Politician 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="politician_id")
    private int id;
    @Column(name="politician_name",nullable=false,length = 50)
    private String name;
    @Column(name="politician_email",nullable=false,length = 50,unique=true)
    private String email; //EMAIL
    @Column(name="politician_gender",nullable=false,length = 20)
    private String gender;
    @Column(name="politician_dob",nullable=false,length = 20)
    private String dateofbirth;
    @Column(name="politician_password",nullable=false,length = 50)
    private String password; //PASSWORD
    @Column(name="politician_position",nullable=false,length = 10)
    private String position;
    @Column(name="politician_party",nullable=false,length = 20)
    private String party;
    @Column(name="politician_contactnumber",nullable=false,length = 20,unique=true)
    private String contact;
    @Column(name="politician_state",length=20)
    private String state;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
