package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Politician;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.CitizenRepository;
import com.klef.jfsd.springboot.repository.PoliticianRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PoliticianRepository politicianRepository;
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	
	@Override
	public Admin checkadminlogin(String username, String pwd) {
		return adminRepository.checkadminlogin(username, pwd);
	}

	@Override
	public String addpolitician(Politician p) {
		politicianRepository.save(p);
		return "Politician Added Successfully";
	}

	@Override
	public List<Politician> viewPolitician() {
		return (List<Politician>) politicianRepository.findAll();
	}

	@Override
	public long citizencount() {
		return citizenRepository.count();
	}

	@Override
	public long politiciancount() {
		return politicianRepository.count();
	}

	@Override
	public String addcitizen(Citizen c) {
		citizenRepository.save(c);
		return "Citizen Added Successfully";
	}

	@Override
	public List<Citizen> viewAllCitizens() {
		return (List<Citizen>)citizenRepository.findAll();
	}

	@Override
	public Citizen viewCitizenByID(int cid) {
		return citizenRepository.findById(cid).get();
	}

	@Override
	public Politician viewPoliticianByID(int pid) {
		return politicianRepository.findById(pid).get();
	}
	
	
	

}
