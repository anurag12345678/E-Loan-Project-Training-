package com.cts.rowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.model.User;

public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int i) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("user_id"));
		user.setName(rs.getString("name"));
		user.setPhone(rs.getString("phone_no"));
		user.setEmail(rs.getString("email_id"));
		user.setAddress(rs.getString("address"));
		user.setLoginName(rs.getString("login_name"));
		user.setRole(rs.getInt("role"));
		user.setLoginStatus(rs.getInt("login_status"));
		return user;
	}

}
