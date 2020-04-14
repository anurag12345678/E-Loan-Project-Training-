package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.ApplicantDao;
import com.cts.model.Applicant;


@Service
public class ApplicantServiceImpl implements ApplicantService {
    
	@Autowired
	private ApplicantDao applicantDao;
	
	
	public void register(Applicant applicant) {
		
		applicantDao.save(applicant);
	}

	public List<Applicant> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
