package com.cts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cts.model.Manager;
import com.cts.model.User;
import com.cts.rowMap.ManagerRowMapper;
import com.cts.rowMap.UserRowMapper;


@Repository
public class ManagerDaoImpl extends BaseDao implements ManagerDao {

	public void save(Manager manager) {
		
		
		String sql ="insert into manager (user_name,password,confirm_password,role)"+"values(:user_name,:password,:confirm_password,:role)";
		Map m = new HashMap();
		m.put("user_name",manager.getManagerName());
		m.put("password",manager.getPassword());
		m.put("confirm_password",manager.getConfirmPassword());
		m.put("role",manager.getRole());
	
		
		KeyHolder kh =new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql,ps,kh);
	
	

	}

	public void update(Manager manager) {
		
		
String sql = "update manager set password=:password where user_name=:user_name";
		
		Map m =new HashMap();
	
		m.put("password",manager.getPassword());
		m.put("user_name",manager.getManagerName());

		
		getNamedParameterJdbcTemplate().update(sql,m);
		
		

	}

	public void delete(Manager manager) {
          
		this.delete(manager.getManagerName());

	}
	
	public void delete(String userName){
		
		String sql ="delete from manager where user_name=?";
		getJdbcTemplate().update(sql,userName);
	}

	public List<Manager> findAll() {
		
		String sql ="select user_name,password,confirm_password,role from manager ";
		List<Manager> managers =getJdbcTemplate().query(sql, new ManagerRowMapper());
		return managers;
		
	} 
	
	

	public Manager finadByUserName(String userName) {
		
		String sql ="select user_name,password,confirm_password,role from manager where user_name=?";
		return getJdbcTemplate().queryForObject(sql,new ManagerRowMapper());
	}
	
	

}
