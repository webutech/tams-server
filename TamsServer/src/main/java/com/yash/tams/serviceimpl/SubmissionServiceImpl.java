package com.yash.tams.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tams.dao.SubmissionDao;
import com.yash.tams.exception.TamsException;
import com.yash.tams.service.SubmissionService;
import com.yash.tams.wrapper.SubmissionWrapper;

@Service
public class SubmissionServiceImpl implements SubmissionService {

	@Autowired
	SubmissionDao submissionDao;
	
	@Override
	public List<SubmissionWrapper> getSubmissionsByAllTrainees(int trainerid) {
		
		try{
			return submissionDao.getSubmissionsByAllTrainees(trainerid);
		}catch (TamsException e) {
			return null;
		}
	}

	@Override
	public List<SubmissionWrapper> getTraineeSubmissions(int traineeid) {
		try{
			return submissionDao.getTraineeSubmissions(traineeid);
		}catch (TamsException e) {
			return null;
		}
	}

	@Override
	public void updateSubmissionStatus(int submissionid, String status) {
		try{
			submissionDao.updateSubmissionStatus(submissionid, status);
		}catch (TamsException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<SubmissionWrapper> filterSubmission(int trainerid, String traineeName, String assignmentName) {
		try{
			return submissionDao.filterSubmission(trainerid, traineeName, assignmentName);
		}catch (TamsException e) {
			e.printStackTrace();
			return null;
		}
	}

}
