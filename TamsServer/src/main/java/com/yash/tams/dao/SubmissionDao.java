package com.yash.tams.dao;

import java.util.List;

import com.yash.tams.exception.TamsException;
import com.yash.tams.model.User;
import com.yash.tams.wrapper.SubmissionWrapper;

public interface SubmissionDao {
	
	public List<SubmissionWrapper> getSubmissionsByAllTrainees(int trainerid) throws TamsException;
	public List<SubmissionWrapper> getTraineeSubmissions(int traineeid) throws TamsException;
	public void updateSubmissionStatus(int submissionid, String status) throws TamsException;
	public List<SubmissionWrapper> filterSubmission(int trainerid, String traineeName, String assignmentName) throws TamsException;
}
