package com.cts.rowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.model.Manager;
import com.cts.model.User;

public class ManagerRowMapper implements RowMapper<Manager> {

	public Manager mapRow(ResultSet rs, int i) throws SQLException {
		
		
		Manager manager = new Manager();
		manager.setManagerName(rs.getString("user_name"));
		manager.setPassword(rs.getString("password"));
		manager.setConfirmPassword(rs.getString("confirm_password"));
		manager.setRole(rs.getString("role"));
	
		return manager;
		
		
	}

}
