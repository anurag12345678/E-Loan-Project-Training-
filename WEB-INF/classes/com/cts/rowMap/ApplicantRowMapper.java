package com.cts.rowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.model.Applicant;



public class ApplicantRowMapper implements RowMapper<Applicant> {
	
	


		public Applicant mapRow(ResultSet rs, int i) throws SQLException {
			Applicant applicant = new Applicant();
		
			
		 applicant.setLoanId(rs.getInt("loan_id"));
		 applicant.setUserName(rs.getString("user_name"));
		 applicant.setApplicationNumber(rs.getString("application_number"));
		 applicant.setLoanAmount(rs.getDouble("loan_amount"));
		 applicant.setLoanApplicationDate(rs.getString("loan_application_date"));
		 applicant.setAcerOfLand(rs.getDouble("acer_of_land"));
		 applicant.setLandValue(rs.getDouble("land_value"));
		 applicant.setRevenueGenerated(rs.getDouble("revenue_generated"));
		 applicant.setPropertyCountry(rs.getString("property_country"));
		 applicant.setPropertyState(rs.getString("property_state"));
			
			return applicant;
		}

	}



