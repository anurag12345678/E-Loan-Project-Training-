package com.cts.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.command.AdminCommand;
import com.cts.command.ClerkCommand;
import com.cts.command.LoginCommand;
import com.cts.command.ManagerCommand;
import com.cts.command.UserCommand;
import com.cts.model.Admin;
import com.cts.model.Clerk;
import com.cts.model.Manager;
import com.cts.service.AdminService;
import com.cts.service.ClerkService;
import com.cts.service.ManagerService;


@Controller
public class AdminController {
	
	
	@Autowired
	private  AdminService adminService;
	
	@Autowired
	private ManagerService managerService;
	
	
	@Autowired
	private ClerkService clerkService;
	
	@RequestMapping("/loginAdmin")
	public String loginPage(Model model)
	{
		model.addAttribute("command",new LoginCommand());
		return "index1";
	}
	
	@RequestMapping(value="/loginAd",method=RequestMethod.POST)
	public String loginHandle(@ModelAttribute("command") LoginCommand cmd,Model model,HttpSession session)
	{
		Admin admin = adminService.login(cmd.getLoginName(),cmd.getPassword());
		
		if(admin==null)
		{
			return "index1";
		}
		return "afterLogin";
	}
	
	@RequestMapping("/reg_form1")
	public String registerForm(Model model){
		
		AdminCommand cmd =new AdminCommand();
		model.addAttribute("command",cmd);
		
		return "reg_form1";
		
	}
	
	@RequestMapping("/registerAd")
	public String registerAdmin(@ModelAttribute("command")AdminCommand cmd){
		
		Admin admin = new Admin();
		
		admin.setAdminName(cmd.getUserName());
		admin.setPassword(cmd.getPassword());
		admin.setName(cmd.getName());
		admin.setPhone(cmd.getPhone());
		admin.setEmail(cmd.getEmail());
		
		adminService.register(admin);
		
		return "index1";
		
	}
	
	@RequestMapping("/addManger")
	public String addManager(Model model){
		
		ManagerCommand cmd = new ManagerCommand();
	    model.addAttribute("command",cmd);
	    return "reg_form2";
		
	}
	
	@RequestMapping("/registerManager")
	public String registerManager(@ModelAttribute("command")ManagerCommand cmd){
		
		Manager manager = new Manager();
		
		manager.setManagerName(cmd.getUserName());
		manager.setPassword(cmd.getPassword());
		manager.setConfirmPassword(cmd.getConfirmPassword());
		manager.setRole(cmd.getRole());
		
		managerService.register(manager);
		
		return "afterLogin";
		
		
	}
	
	@RequestMapping("/addClerk")
	public String addClerk(Model model){
		
		ClerkCommand cmd = new ClerkCommand();
		
		model.addAttribute("command",cmd);
		
		return "reg_form3";
		
	}
	@RequestMapping("/registerClerk")
	public String registerClerk(@ModelAttribute("command")ClerkCommand cmd){
		
		Clerk clerk = new Clerk();
		clerk.setUserName(cmd.getUserName());
		clerk.setPassword(cmd.getPassword());
		clerk.setConfirmPassword(cmd.getConfirmPassword());
		clerk.setRole(cmd.getRole());
		
		clerkService.register(clerk);
		return "afterLogin";
				
	}
	
    @RequestMapping("/managerList")
	public String managerListPage(Model model){
    	model.addAttribute("managerList",managerService.getUserList());
		return "list1";
	}
    
    
    @RequestMapping("/clerkList")
    public String clerkListPage(Model model){
    	
    	model.addAttribute("clerkList",clerkService.getUserList());
    	return "list2";
    	
    }
    
    @RequestMapping("/deleteManager")
    public String deleteManager(@RequestParam ("uname") String userName){
    	
    	managerService.delete(userName);
    	return "list1";
    	
    }
    @RequestMapping("/editManager")
    public String editManager(Model model,HttpSession session,@RequestParam("uname") String userName){
    	
    	session.setAttribute("a",userName);
    	
    	Manager manager =managerService.findByUserName(userName);
    	model.addAttribute("command",manager);
    	return "reg_form2";
    }
    
    @RequestMapping("/deleteClerk")
    public String deleteClerk(@RequestParam ("uname") String userName){
    	
    	clerkService.delete(userName);
    	return "list2";
    	
    }
    @RequestMapping("/editClerk")
    public String editClerk(Model model,HttpSession session,@RequestParam("uname") String userName){
    	
    	session.setAttribute("a",userName);
    	
    	Clerk clerk =clerkService.findByUserName(userName);
    	model.addAttribute("command",clerk);
    	return "reg_form2";
    }
	
    

}
