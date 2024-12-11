package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Issue;
import com.klef.jfsd.springboot.model.Politician;
import com.klef.jfsd.springboot.model.Scheme;

public interface PoliticianService 
{
public Politician checkpoliticianlogin(String email,String password);
public List<Issue> viewAllIssues();

public String insertScheme(Scheme s);

public String politicianUpdate(Politician p);

public List<Scheme> getGovtSchemes();

}
