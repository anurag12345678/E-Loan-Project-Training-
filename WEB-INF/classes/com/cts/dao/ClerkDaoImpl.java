package com.cts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cts.model.Clerk;
import com.cts.model.Manager;
import com.cts.rowMap.ClerkRowMapper;
import com.cts.rowMap.ManagerRowMapper;

@Repository
public class ClerkDaoImpl extends BaseDao implements ClerkDao {

	public void save(Clerk clerk) {
	
		String sql ="insert into clerk (user_name,password,confirm_password,role)"+"values(:user_name,:password,:confirm_password,:role)";
		Map m = new HashMap();
		m.put("user_name",clerk.getUserName());
		m.put("password",clerk.getPassword());
		m.put("confirm_password",clerk.getConfirmPassword());
		m.put("role",clerk.getRole());
	
	
		
		KeyHolder kh =new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql,ps,kh);
	
		

	}

	public void update(Clerk clerk) {
		
		
String sql = "update clerk set password=:password where user_name=:user_name";
		
		Map m =new HashMap();
		m.put("password",clerk.getPassword());
		m.put("user_name",clerk.getUserName());

		
		getNamedParameterJdbcTemplate().update(sql,m);

	}

	public void delete(Clerk clerk) {
		
		
		this.delete(clerk.getUserName());

	}

	public void delete(String userName) {
		
		
		String sql ="delete from clerk where user_name=?";
		getJdbcTemplate().update(sql,userName);

	}

	public List<Clerk> findAll() {
		

		String sql ="select user_name,password,confirm_password,role from clerk ";
		List<Clerk> clerks =getJdbcTemplate().query(sql, new ClerkRowMapper());
		return clerks;
	}

	public Clerk findByUserName(String userName) {
		
		String sql ="select user_name,password,confirm_password,role from clerk where user_name=? ";
		return getJdbcTemplate().queryForObject(sql,new ClerkRowMapper());
		
	}

}
