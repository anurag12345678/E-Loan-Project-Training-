package com.cts.dao;

import java.util.List;

import com.cts.model.User;

public interface UserDao {

	
	public void save(User user);
	
	public void update(User user);
	
	public void delete(User user);
	
	public void delete(Integer userId);
	
	public User  findById(Integer userId);
	
	public List<User> findAll();
	
	public List<User> findByProperty();
	
}
