package com.klef.jfsd.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import com.klef.jfsd.springboot.service.CitizenService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@RestController
@RequestMapping("/citizen")
public class CitizenController 
{
	@Autowired
	private CitizenService citizenService;
	
	@Autowired
    private JavaMailSender emailSender;
	
	@GetMapping("/")
	public String home()
	{
		return "Praja Seva";
	}
	
	@PostMapping("/register")
	public String citizenregistration(@RequestBody Citizen c)
	{
		return citizenService.citizenregistration(c);
	}
	
	@PostMapping("/citizenlogin")
	public Citizen citizenlogin(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		return citizenService.citizenlogin(email, password);
	}
	
	@PutMapping("updatecitizen/{id}")
	public String updateCitizen(@PathVariable("id") int id,@RequestBody Citizen c)
	{
		c.setId(id);
		return citizenService.citizenUpdate(c);
	}
	
//	@PostMapping("/submitissue")
//	public String addIssue(@RequestBody Issue s)
//	{
//		return citizenService.issueAdd(s);
//	}
	
	@PostMapping("/{citizenId}/issues")
	  public Issue createIssueForCitizen(@PathVariable int citizenId,@RequestBody Issue issue)
	    {
	    return citizenService.createIssueForCitizen(citizenId, issue);
	  }
	
	@GetMapping("/viewallissues")
	public List<Issue> viewAllIssues()
	{
		return citizenService.viewAllIssues();
	}
	
	@PostMapping("/send-email")
    public String sendEmail(@RequestBody Map<String, String> emailDetails) throws MessagingException {
        // Extracting email details from the request body
        String senderName = emailDetails.get("name");
        String recipientEmail = emailDetails.get("email");
        String emailSubject = emailDetails.get("subject");
        String emailMessage = emailDetails.get("message");

        // Create MimeMessage and set up email properties
        MimeMessage email = emailSender.createMimeMessage();
        MimeMessageHelper emailHelper = new MimeMessageHelper(email, true);

        emailHelper.setTo(recipientEmail);
        emailHelper.setSubject(emailSubject);
        emailHelper.setFrom("kesavachandra2004@gmail.com");

        // HTML content for the email body
        String emailBody = "<h3>Message from Contact Form</h3>" +
                "<p><strong>Name:</strong> " + senderName + "</p>" +
                "<p><strong>Recipient:</strong> " + recipientEmail + "</p>" +
                "<p><strong>Subject:</strong> " + emailSubject + "</p>" +
                "<p><strong>Message:</strong> " + emailMessage + "</p>";

        emailHelper.setText(emailBody, true);

        // Send email
        emailSender.send(email);

        return "Email has been successfully sent!";
    }
	  
	
	
}
