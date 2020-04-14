package com.cts.rowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.model.Clerk;

public class ClerkRowMapper implements RowMapper<Clerk>{

	public Clerk mapRow(ResultSet rs, int i) throws SQLException {
		
		Clerk clerk = new Clerk();
		
		clerk.setUserName(rs.getString("user_name"));
		clerk.setPassword(rs.getString("password"));
		clerk.setConfirmPassword(rs.getString("confirm_password"));
		clerk.setRole(rs.getString("role"));
		
		return clerk;
		

	}

}
