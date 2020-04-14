package com.cts.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.command.LoginCommand;
import com.cts.exception.UserBlockedException;
import com.cts.model.Manager;
import com.cts.service.ManagerService;
import com.cts.service.UserService;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/loginManager")
	public String welManager(Model model){
		
		LoginCommand cmd = new LoginCommand();
		model.addAttribute("command",cmd);
		
		return "index2";
		
	}
	
	@RequestMapping(value="/loginMag",method= RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model model){
		
		
		Manager manager= managerService.login(cmd.getLoginName(),cmd.getPassword());
		if(manager== null)
		{
			
			return "index2";
		}else{
			
			return "dashboard_mag";
		}
		}
	
		 //JSP-/WEB-INF/view/index.jsp
	}
	
	


