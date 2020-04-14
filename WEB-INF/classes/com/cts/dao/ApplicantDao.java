package com.cts.dao;

import java.util.List;

import com.cts.model.Applicant;

public interface ApplicantDao {
	
	
	public void save(Applicant applicant);
	
	public List<Applicant> findAll(Applicant applicant);

}
