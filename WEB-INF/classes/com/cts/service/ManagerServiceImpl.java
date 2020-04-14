package com.cts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cts.dao.BaseDao;
import com.cts.dao.ManagerDao;
import com.cts.exception.UserBlockedException;
import com.cts.model.Manager;
import com.cts.model.User;
import com.cts.rowMap.ManagerRowMapper;
import com.cts.rowMap.UserRowMapper;


@Service
public class ManagerServiceImpl extends BaseDao implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	public void register(Manager manager) {
		managerDao.save(manager);

	}

	public Manager login(String loginName, String password) {
		
		String sql = "select user_name,password,confirm_password,role from manager where user_name=:ln and password=:pw";
		Map m = new HashMap();
		m.put("ln",loginName);
		m.put("pw",password);
		
		
		try{
			
		Manager manager = getNamedParameterJdbcTemplate().queryForObject(sql,m, new ManagerRowMapper());

		if(manager==null)
		{
			return null;
		}
		else{
		return manager;
		}  
		}
		catch(EmptyResultDataAccessException ex){
		
			return null;	}
		
	}

	public List<Manager> getUserList() {
	
		return  managerDao.findAll();
		

	}

	public void update(Manager manager) {
	
		
		managerDao.update(manager);
		
	}

	public void delete(String userName) {
		
		managerDao.delete(userName);
		
	}

	public Manager findByUserName(String userName) {
		
		
		return managerDao.finadByUserName(userName);
	}

}
