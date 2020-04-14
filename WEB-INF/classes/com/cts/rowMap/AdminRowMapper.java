package com.cts.rowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.model.Admin;

public class AdminRowMapper implements RowMapper<Admin>{

	public Admin mapRow(ResultSet rs, int i) throws SQLException {
		
		Admin admin =new Admin();
		
		admin.setAdminName(rs.getString("user_name"));
		admin.setPassword(rs.getString("password"));
		admin.setName(rs.getString("name"));
		admin.setPhone(rs.getString("phone_no"));
		admin.setEmail(rs.getString("email_id"));
		
		
		return admin;
	}

}
