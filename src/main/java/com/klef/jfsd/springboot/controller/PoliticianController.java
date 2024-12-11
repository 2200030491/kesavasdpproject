package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Issue;
import com.klef.jfsd.springboot.model.Politician;
import com.klef.jfsd.springboot.model.Scheme;
import com.klef.jfsd.springboot.repository.IssueRepository;
import com.klef.jfsd.springboot.service.PoliticianService;

@RestController
@RequestMapping("/politician")
public class PoliticianController 
{
	@Autowired
	private PoliticianService politicianService;
	@GetMapping("/")
	public String home()
	{
		return "Politician";
	}
	
	@PostMapping("/politicianlogin")
	public Politician politicianlogin(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		return politicianService.checkpoliticianlogin(email, password);
	}
	
	@GetMapping("/viewallissues")
	public List<Issue> viewAllIssues()
	{
		return politicianService.viewAllIssues();
	}
	
	@PostMapping("/insertscheme")
	public String insertScheme(@RequestBody Scheme s)
	{
		return politicianService.insertScheme(s);
	}
	
	
	@PutMapping("/updatepoliticianprofile/{id}")
	public String updatePoliticianProfile(@PathVariable int id,@RequestBody Politician p)
	{
		p.setId(id);
		return politicianService.politicianUpdate(p);
	}
	@GetMapping("/getschemes")
	public List<Scheme> getAllSchemes()
	{
		return politicianService.getGovtSchemes();
	}
	
}
