package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Politician;
import com.klef.jfsd.springboot.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/")
	public String home()
	{
		return "Admin";
	}
	
	@PostMapping("/adminlogin")
	public Admin checkadminlogin(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		return adminService.checkadminlogin(username, password);
	}
	
	@PostMapping("/addpolitician")
	public String addpolitician(@RequestBody Politician p)
	{
		return adminService.addpolitician(p);
	}
	
	@GetMapping("/viewpoliticians")
	public List<Politician> viewPoliticians()
	{
		return adminService.viewPolitician(); 
	}
	
	@GetMapping("/citizencount")
	public long citizencount()
	{
		return adminService.citizencount();
	}
	
	@GetMapping("/politiciancount")
	public long politiciancount()
	{
		return adminService.politiciancount();
	}
	
	@PostMapping("/addcitizen")
	public String addcitizen(@RequestBody Citizen c)
	{
		return adminService.addcitizen(c);
	}
	
	@GetMapping("/viewallcitizens")
	public List<Citizen> viewAllCitizens()
	{
		return adminService.viewAllCitizens();
	}
	
	@GetMapping("/viewcitizenbyid")
	public Citizen viewcitizenbyid(@RequestParam("id") int id)
	{
		return adminService.viewCitizenByID(id);
	}
	
	
	@GetMapping("/viewpoliticianbyid")
	public Politician viewpoliticianbyid(@RequestParam("id") int id)
	{
		return adminService.viewPoliticianByID(id);
	}
}
