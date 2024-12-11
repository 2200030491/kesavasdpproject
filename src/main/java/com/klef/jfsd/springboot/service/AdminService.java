package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Politician;

public interface AdminService 
{
	public Admin checkadminlogin(String username,String pwd);
	public String addpolitician(Politician p);
	public List<Politician> viewPolitician();
	
	public long citizencount();
	public long politiciancount();
	public String addcitizen(Citizen c);
	public List<Citizen> viewAllCitizens();
	public Citizen viewCitizenByID(int cid);
	public Politician viewPoliticianByID(int pid);

}
