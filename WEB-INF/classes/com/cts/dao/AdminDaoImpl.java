package com.cts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cts.model.Admin;
import com.cts.model.Manager;
import com.cts.rowMap.AdminRowMapper;
import com.cts.rowMap.ManagerRowMapper;


@Repository
public class AdminDaoImpl extends BaseDao implements AdminDao {

	public void save(Admin admin) {
		
		
		String sql ="insert into admin (user_name,password,name,phone_no,email_id)"+"values(:user_name,:password,:name,:phone_no,:email_id)";
		Map m = new HashMap();
		m.put("user_name",admin.getAdminName());
		m.put("password",admin.getPassword());
		m.put("name",admin.getName());
		m.put("phone_no",admin.getPhone());
		m.put("email_id",admin.getEmail());
	
		
		KeyHolder kh =new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql,ps,kh);
	
	
		
		
	}

	public List<Admin> finadAll() {
		
		String sql ="select user_name,password,name,phone_no,email_id from admin ";
		List<Admin> admins =getJdbcTemplate().query(sql, new AdminRowMapper());
		return admins;
		
		
		
	}

}
