package com.klef.jfsd.springboot.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Issue;
import com.klef.jfsd.springboot.repository.CitizenRepository;
import com.klef.jfsd.springboot.repository.IssueRepository;

import jakarta.transaction.Transactional;

@Service
public class CitizenServiceImpl implements CitizenService
{

	@Autowired
	private CitizenRepository citizenRepository;
	@Autowired
	private IssueRepository issueRepository;
	
	@Override
	public String citizenregistration(Citizen c) {
		citizenRepository.save(c);
		return "Citizen Registered Successfully";
	}
	
	@Override
	public Citizen citizenlogin(String email, String password) {
		return citizenRepository.checkcitizenlogin(email, password);
	}

	@Override
	public String citizenUpdate(Citizen c) {
		Optional<Citizen> c1 = citizenRepository.findById(c.getId());
		String message = null;
		if(c1.isPresent())
		{
			Citizen c2 = c1.get();
			c2.setName(c.getName());
			c2.setAadhaarnumber(c.getAadhaarnumber());
			c2.setDateofbirth(c.getDateofbirth());
			c2.setEmail(c.getEmail());
			c2.setGender(c.getGender());
			c2.setMobile(c.getMobile());
			c2.setState(c.getState());
			citizenRepository.save(c2);
			message = "Citizen Updated Successfully";
			
		}
		else
		{
			message = "Citizen ID Not Found";
		}
		return message;
		
	}

//	@Override
//	public String issueAdd(Issue s) {
//		issueRepository.save(s);
//		return "Issue Submitted Successfully";
//	}

	@Override
	@Transactional
	  public Issue createIssueForCitizen(int citizenId, Issue issue) {
	    Optional<Citizen> opcitizen = citizenRepository.findById(citizenId);
	    if(opcitizen.isEmpty())
	    {
	      throw new RuntimeException("Citizen Not Found");
	    }
	    
	      Citizen citizen = opcitizen.get();
	      issue.setCitizen(citizen);
	      issue.setCreatedAt(LocalDateTime.now());
	      
	      return issueRepository.save(issue);
	    
	  }

	@Override
	public List<Issue> viewAllIssues() {
		return (List<Issue>)issueRepository.findAll();
	}
	
}
