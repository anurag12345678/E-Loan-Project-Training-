package com.cts.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.command.ApplyLoanCommand;
import com.cts.command.LoginCommand;
import com.cts.command.UserCommand;
import com.cts.exception.UserBlockedException;
import com.cts.model.Applicant;
import com.cts.model.User;
import com.cts.service.ApplicantService;
import com.cts.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicantService applicantService;
	
	/*
	@RequestMapping("/index")
	
	public String index(Model model){
		model.addAttribute("command",new LoginCommand());
		return "index" ; //JSP-/WEB-INF/view/index.jsp
	}
	
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model model,HttpSession session){
		
		try{
		User loggedInUser= userService.login(cmd.getLoginName(),cmd.getPassword());
		if(loggedInUser== null)
		{
			model.addAttribute("error","Login Failed Enter Vaild Credentials");
			return "index";
		}else{
			//Sucess 
			// Check the Role And Redirect to a appropriate dashboard
			if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN))
			{
				addUserInSession(loggedInUser,session);
				System.out.println(cmd.getLoginName());
				return "redirect:admin/dashboard";
			}
			else if(loggedInUser.getRole().equals(UserService.ROLE_USER))
			{   addUserInSession(loggedInUser,session);
				return "redirect:user/dashboard";
			}
			else{
				model.addAttribute("error","Invaild User Role");
				return "index";
			}
		}
		}
		catch(UserBlockedException ex)
		{
			model.addAttribute("error",ex.getMessage());
			return "index";
		}
		 //JSP-/WEB-INF/view/index.jsp
	}
	*/
	
	@RequestMapping(value="/user/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "index" ; //JSP-/WEB-INF/view/dashboard_user.jsp
	}
	


     
	@RequestMapping(value="/reg_form")
	public String registrationForm(Model model){
		UserCommand cmd = new UserCommand();
		
		model.addAttribute("command",cmd);
		return "reg_form";//jsp Page
	}
	
	@RequestMapping(value="/register")
	public String registerUser(@ModelAttribute("command")UserCommand cmd,Model m){
		try{
		User user =cmd.getUser();
		user.setRole(UserService.ROLE_USER);
		user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
		userService.register(user);
		}
		catch(DuplicateKeyException e)
		{  e.printStackTrace();
			m.addAttribute("err","User name is Alredy Registered. plzz try with other username");
			return "reg_form";
		}
		
		return "redirect:index";//jsp Page
	}

	

	@RequestMapping(value="/user/apply")
	public String applyLoan(@ModelAttribute("command")ApplyLoanCommand cmd,Model m){
		
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
	
		
		return "Thankyou";//jsp Page
	}
	
	@RequestMapping(value="/user/dashboard")
	public String userDashboard(){
		
		return "dashboard_user" ; //JSP-/WEB-INF/view/dashboard_user.jsp
	}
	
	@RequestMapping(value="/admin/dashboard")
	public String adimDashboard(){
		
		return "dashboard_admin" ; //JSP-/WEB-INF/view/dashboard_admin.jsp
	}
	
	@RequestMapping(value="/admin/users")
	public String getUserList(Model m)
	{
		m.addAttribute("usersList",userService.getUserList());
		
		return "users";
	}
	
	@RequestMapping(value="/user/PropertyDetails")
	public String applyLoan(Model model){
	  model.addAttribute("command",new ApplyLoanCommand());
		return "PropertyDetails";
	}
	
	private void addUserInSession(User user,HttpSession session){
		
		session.setAttribute("user",user);
		session.setAttribute("userId",user.getUserId());
		session.setAttribute("role",user.getRole());
	}
	
	
}
