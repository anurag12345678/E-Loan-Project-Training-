package com.cts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cts.dao.AdminDao;
import com.cts.dao.BaseDao;
import com.cts.model.Admin;
import com.cts.model.Manager;
import com.cts.rowMap.AdminRowMapper;
import com.cts.rowMap.ManagerRowMapper;

@Service
public class AdminServiceImpl extends BaseDao implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	public void register(Admin admin) {
	
		adminDao.save(admin);
		
	}

	public Admin login(String loginName, String password) {
		
		String sql = "select user_name,password,name,phone_no,email_id from admin where user_name=:ln and password=:pw";
		Map m = new HashMap();
		m.put("ln",loginName);
		m.put("pw",password);
		
		
		try{
			
		Admin admin = getNamedParameterJdbcTemplate().queryForObject(sql,m, new AdminRowMapper());

		if(admin==null)
		{
			return null;
		}
		else{
		return admin;
		}  
		}
		catch(EmptyResultDataAccessException ex){
		
			return null;	}
	
	}

	public List<Admin> getUserList() {

		return adminDao.finadAll();
	}

}
