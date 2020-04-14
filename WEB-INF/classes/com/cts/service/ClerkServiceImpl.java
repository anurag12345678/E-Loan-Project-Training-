package com.cts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cts.dao.BaseDao;
import com.cts.dao.ClerkDao;
import com.cts.model.Clerk;
import com.cts.model.Manager;
import com.cts.rowMap.ClerkRowMapper;
import com.cts.rowMap.ManagerRowMapper;


@Service
public class ClerkServiceImpl extends BaseDao implements ClerkService {
	
	@Autowired
	private ClerkDao clerkDao;

	public void register(Clerk clerk) {
		
		
		clerkDao.save(clerk);

	}

	public Clerk login(String loginName, String password) {
		
		String sql = "select user_name,password,confirm_password,role from clerk where user_name=:ln and password=:pw";
		Map m = new HashMap();
		m.put("ln",loginName);
		m.put("pw",password);
		
		
		try{
			
		Clerk clerk = getNamedParameterJdbcTemplate().queryForObject(sql,m, new ClerkRowMapper());

		if(clerk==null)
		{
			return null;
		}
		else{
		return  clerk;
		}  
		}
		catch(EmptyResultDataAccessException ex){
		
			return null;	}
		
	}

	public List<Clerk> getUserList() {
		
		return clerkDao.findAll();
	

}

	public void update(Clerk clerk) {
		
		clerkDao.update(clerk);
		
	}

	public void delete(String userName) {
		clerkDao.delete(userName);
		
	}

	public Clerk findByUserName(String UserName) {
		
		return clerkDao.findByUserName(UserName);
	}
}
