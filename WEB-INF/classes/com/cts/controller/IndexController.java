package com.cts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value="/login")
	public String loginPage(){
		return "Welcome";
	}
	@RequestMapping(value="contact")
	public String contactPage(){
		return "Contact";
	}
	@RequestMapping(value="/news")
	public String newsPage(){
		return "News";
	}
}