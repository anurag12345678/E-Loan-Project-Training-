package com.cts.service;

import java.util.List;

import com.cts.model.Clerk;


public interface ClerkService {
	
	
public void register(Clerk clerk);
	
	public Clerk login(String loginName,String password);
    
	
	public List<Clerk> getUserList();
	
	public void update(Clerk clerk);
	
	public void delete(String userName);
	
	public Clerk findByUserName(String UserName);
	

}
