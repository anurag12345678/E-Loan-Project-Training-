package com.cts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cts.model.User;
import com.cts.rowMap.UserRowMapper;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

	public void save(User user) {
		
		String sql ="insert into user (name,phone_no,email_id,address,login_name,password,role,login_status)"+"values(:name,:phone_no,:email_id,:address,:login_name,:password,:role,:login_status)";
		Map m = new HashMap();
		m.put("name",user.getName());
		m.put("phone_no",user.getPhone());
		m.put("email_id",user.getEmail());
		m.put("address",user.getAddress());
		m.put("login_name",user.getLoginName());
		m.put("password",user.getPassword());
		m.put("role",user.getRole());
		m.put("login_status",user.getLoginStatus());
		
		KeyHolder kh =new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql,ps,kh);
		Integer userId = kh.getKey().intValue();
		user.setUserId(userId);
	}

	public void update(User user) {
		
		String sql = "update user set name=:name, phone_no=:phone_no, email_id=:email_id,address=:address,role=:role,login_status=:login_status where user_id=:user_id";
		
		Map m =new HashMap();
		m.put("name",user.getName());
		m.put("phone_no",user.getPhone());
		m.put("email_id",user.getEmail());
		m.put("address",user.getAddress());
		m.put("role",user.getRole());
		m.put("login_status",user.getLoginStatus());
		m.put("user_id",user.getUserId());
		
		getNamedParameterJdbcTemplate().update(sql,m);
		
		
	}

	public void delete(User user) {
		this.delete(user.getUserId());
		
	}

	public void delete(Integer userId) {
		String sql ="delete from user where user_id=?";
		getJdbcTemplate().update(sql,userId);
		
		
	}

	public User findById(Integer userId) {
	
 String sql ="select user_id,name,phone_no,email_id,address,loginName,role,login_status from user where user_id =?";
	User user =	getJdbcTemplate().queryForObject(sql,new UserRowMapper());
		
		return user;
	}

	public List<User> findAll() {
		String sql ="select user_id,name,phone_no,email_id,address,loginName,role,login_status from user ";
		List<User> users =getJdbcTemplate().query(sql, new UserRowMapper());
		return users;
	}

	public List<User> findByProperty() {
		String sql ="select user_id,name,phone_no,email_id,address,login_name,role,login_status from user where role= 2"; 
		List<User> users = getJdbcTemplate().query(sql,new UserRowMapper());
		return users;
	}
	
	
	
	

}
