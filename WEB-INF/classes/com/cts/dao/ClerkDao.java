package com.cts.dao;

import java.util.List;

import com.cts.model.Clerk;


public interface ClerkDao {
	
	
public void save(Clerk clerk);
	
	public void update(Clerk clerk);
	
	public void delete(Clerk clerk);
	
	public void delete(String userName);
	
	public List<Clerk> findAll();
	
	public Clerk findByUserName(String userName);

}
