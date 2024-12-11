package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Issue;

public interface CitizenService {
	public String citizenregistration(Citizen c);
	public Citizen citizenlogin(String email,String password);
	public String citizenUpdate(Citizen c);
	public Issue createIssueForCitizen(int citizenId,Issue issue);
	public List<Issue> viewAllIssues();
	
	
}
