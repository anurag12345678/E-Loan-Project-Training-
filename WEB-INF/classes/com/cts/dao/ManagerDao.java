package com.cts.dao;

import java.util.List;

import com.cts.model.Manager;



public interface ManagerDao {
	
	
   public void save(Manager manager);
	
	public void update(Manager manager);
	
	public void delete(Manager manager);
	
	public void delete(String userName);
	
	public List<Manager> findAll();
	
	public Manager finadByUserName(String userName);
	

}
