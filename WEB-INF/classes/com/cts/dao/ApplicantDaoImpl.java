package com.cts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cts.model.Applicant;
import com.cts.model.User;
import com.cts.rowMap.ApplicantRowMapper;
import com.cts.rowMap.UserRowMapper;

@Repository
public class ApplicantDaoImpl extends BaseDao implements ApplicantDao {

	public void save(Applicant applicant) {
		
		String sql ="insert into applicant (user_name,application_number,loan_amount,loan_application_date,acer_of_land,land_value,revenue_generated,property_country,property_state)"+"values(:user_name,:application_number,:loan_amount,:loan_application_date,:acer_of_land,:land_value,:revenue_generated,:property_country,:property_state)";
		Map m = new HashMap();
		m.put("user_name",applicant.getUserName());
		m.put("application_number",applicant.getApplicationNumber());
		m.put("loan_amount",applicant.getLoanAmount());
		m.put("loan_application_date",applicant.getLoanApplicationDate());
		m.put("acer_of_land",applicant.getAcerOfLand());
		m.put("land_value",applicant.getLandValue());
		m.put("revenue_generated",applicant.getRevenueGenerated());
		m.put("property_country",applicant.getPropertyCountry());
		m.put("property_state",applicant.getPropertyState());
		
		KeyHolder kh =new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql,ps,kh);
		Integer loanId = kh.getKey().intValue();
		applicant.setLoanId(loanId);

	}

	public List<Applicant> findAll(Applicant applicant) {
		
		String sql ="select loan_id,user_name,application_number,loan_amount,loan_application_date,acer_of_land,land_value,revenue_generated,property_country,property_state from applicant ";
		List<Applicant> applicants =getJdbcTemplate().query(sql, new ApplicantRowMapper());
		return applicants;
	}

}
