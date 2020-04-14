package com.cts.service;

import java.util.List;

import com.cts.model.Applicant;


public interface ApplicantService {
	
	public static final Integer loan_status_aproved = 1;
	public static final Integer loan_status_pending =2;
	public static final Integer loan_status_reject =3;
	
	public void register(Applicant applicant);
	public List<Applicant> getUserList();
	

}
