package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="citizen_table")
public class Citizen 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="citizen_id")
	private int id;
	@Column(name="citizen_name",nullable=false,length = 50)	
	private String name;
	@Column(name="citizen_email",nullable=false,length = 50,unique=true)
	private String email; //EMAIL------------------
	@Column(name="citizen_gender",nullable=false,length = 20)
	private String gender;
	@Column(name="citizen_dob",nullable=false,length = 20)
	private String dateofbirth;	
	@Column(name="citizen_password",nullable=false,length = 50)
	private String password;//PASSWORD---------------
	@Column(name="citizen_aadhaarnumber",nullable=false,length = 12,unique=true)
	private long aadhaarnumber;
	@Column(name="citizen_mobile",nullable=false,length = 20,unique=true)
	private String mobile;
	@Column(name="citizen_state",length=20)
	private String state;
	
	public Citizen()
	{
		
	}
	public Citizen(int id, String name, String email, String gender, String dateofbirth, String password,
			long aadhaarnumber, String mobile, String state) {
		//	super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.password = password;
		this.aadhaarnumber = aadhaarnumber;
		this.mobile = mobile;
		this.state = state;
	}
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
	public long getAadhaarnumber() {
		return aadhaarnumber;
	}
	public void setAadhaarnumber(long aadhaarnumber) {
		this.aadhaarnumber = aadhaarnumber;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
