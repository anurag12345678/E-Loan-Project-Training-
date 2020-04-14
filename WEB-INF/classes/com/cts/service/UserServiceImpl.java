package com.cts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cts.dao.BaseDao;
import com.cts.dao.UserDao;
import com.cts.exception.UserBlockedException;
import com.cts.model.User;
import com.cts.rowMap.UserRowMapper;


@Service
public class UserServiceImpl extends BaseDao implements UserService{
      
	@Autowired
	private UserDao userDao;
	
	
	public void register(User user) {
		userDao.save(user);
		
	}

	public User login(String loginName, String password) throws UserBlockedException {
	String sql = "select user_id,name,phone_no,email_id,address,role,login_status,login_name from user where login_name=:ln and password=:pw";
	Map m = new HashMap();
	m.put("ln",loginName);
	m.put("pw",password);
	
	
	try{
		
	User user = getNamedParameterJdbcTemplate().queryForObject(sql,m, new UserRowMapper());

	if(user.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED))
	{
		throw new UserBlockedException("Your Account Has Been Blocked . Contact to Admin");
	}
	else{
	return user;
	}  
	}
	catch(EmptyResultDataAccessException ex){
	
		return null;	}
		
	}

	public List<User> getUserList() {
		
		return userDao.findByProperty();
		
	}

	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub
		
	}

}
