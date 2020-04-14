package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.command.ApplyLoanCommand;
import com.cts.command.LoginCommand;
import com.cts.command.UserCommand;
import com.cts.model.Applicant;
import com.cts.model.Clerk;
import com.cts.model.User;
import com.cts.service.ApplicantService;
import com.cts.service.ClerkService;
import com.cts.service.UserService;

@Controller
public class ClerkController {
	
	
	@Autowired
	private ClerkService clerkService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicantService applicantService;
	
	@RequestMapping("/index")
	public String loginPage(Model model){
		
		LoginCommand cmd = new LoginCommand();
		model.addAttribute("command",cmd);
		
		return "index";
	}
	
	
	@RequestMapping("/loginClerk")
	public String loginClerk(@ModelAttribute("command")LoginCommand cmd){
		
		Clerk clerk = clerkService.login(cmd.getLoginName(),cmd.getPassword());
		
		if(clerk== null){
			return null;
		}
		else{
			return "dashboard_user";
		}
		
		
		
	    	
	}
	
	@RequestMapping("/registerApplicant")
	public String registerApplicant(Model model){
		UserCommand cmd = new UserCommand();
		model.addAttribute("command",cmd);
		return "reg_form";
		
	}
	
	@RequestMapping("/registerClient")
	public String applicantRegister(@ModelAttribute("command")UserCommand cmd)
	{
		User user = cmd.getUser();
		user.setRole(UserService.ROLE_USER);
		user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		userService.register(user);
	     return "dashboard_user";	
	}
	
	
	@RequestMapping("/applyLoan")
	public String applyLoan(Model model){
		
		ApplyLoanCommand cmd = new ApplyLoanCommand();
		model.addAttribute("command",cmd);
		return "PropertyDetails";
	}
	
	
	@RequestMapping("/apply")
	public String apply(@ModelAttribute("command") ApplyLoanCommand cmd)
	{
		Applicant applicant = new Applicant(); 
		applicant.setUserName(cmd.getUserName());
		applicant.setApplicationNumber(cmd.getApplicationNumber());
		applicant.setLoanAmount(cmd.getLoanAmount());
		applicant.setLoanApplicationDate(cmd.getLoanApplicationDate());
		applicant.setAcerOfLand(cmd.getAcerOfLand());
		applicant.setLandValue(cmd.getLandValue());
		applicant.setRevenueGenerated(cmd.getRevenueGenerated());
		applicant.setPropertyCountry(cmd.getPropertyCountry());
		applicant.setPropertyState(cmd.getPropertyState());
		applicant.setLoanStatus(ApplicantService.loan_status_pending);
		applicant.setLoanId(cmd.getLoanId());		
		applicantService.register(applicant);
	
		
		return "Thankyou";
		
		
		
	}
	
	@RequestMapping("/dashboard")
	public String returnDashboard(){
		
		return "dashboard_user";
	}

}
