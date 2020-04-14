package com.cts.service;

import java.util.List;

import com.cts.model.Admin;





public interface AdminService {
	
	
public void register(Admin admin);
	
	public Admin login(String loginName,String password);
    
	
	public List<Admin> getUserList();
	

}
