package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Issue;
import com.klef.jfsd.springboot.model.Politician;
import com.klef.jfsd.springboot.model.Scheme;
import com.klef.jfsd.springboot.repository.IssueRepository;
import com.klef.jfsd.springboot.repository.PoliticianRepository;
import com.klef.jfsd.springboot.repository.SchemeRepository;

@Service
public class PoliticianServiceImpl implements PoliticianService
{

	@Autowired
	private PoliticianRepository politicianRepository;
	@Autowired
	private IssueRepository issueRepository;
	@Autowired
	private SchemeRepository schemeRepository;
	
	@Override
	public Politician checkpoliticianlogin(String email, String password) {
		return politicianRepository.checkpoliticianlogin(email, password);
	}

	@Override
	public List<Issue> viewAllIssues() {
		return (List<Issue>) issueRepository.findAll();
	}

	@Override
	public String insertScheme(Scheme s) {
		schemeRepository.save(s);
		return "Scheme Inserted Successfully";
	}

	@Override
	public String politicianUpdate(Politician p) {
		Optional<Politician> p1 = politicianRepository.findById(p.getId());
		String message = null;
		if(p1.isPresent())
		{
			Politician p2 = p1.get();
			p2.setName(p.getName());
			p2.setDateofbirth(p.getDateofbirth());
			p2.setEmail(p.getEmail());
			p2.setContact(message);
			p2.setGender(p.getGender());
			p2.setParty(p.getParty());
			p2.setPosition(p.getPosition());
			p2.setState(p.getState());
			politicianRepository.save(p2);
			message = "Politcian Updated Successfully";
			
		}
		else
		{
			message = "Politician ID Not Found";
		}
		return message;
		
	}

	@Override
	public List<Scheme> getGovtSchemes() {
		return (List<Scheme>)schemeRepository.findAll();
	}
	
	
}
