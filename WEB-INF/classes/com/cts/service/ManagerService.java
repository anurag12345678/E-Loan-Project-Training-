package com.cts.service;

import java.util.List;

import com.cts.exception.UserBlockedException;
import com.cts.model.Manager;


public interface ManagerService {
	
	
public void register(Manager manger);
	
	public Manager login(String loginName,String password);

     public  List<Manager> getUserList();
     
     public void update(Manager manager);
     
     public void delete(String userName);
     
     public Manager findByUserName(String userName);
	

}
