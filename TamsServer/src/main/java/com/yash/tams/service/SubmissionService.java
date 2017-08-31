package com.yash.tams.service;

import java.util.List;

import com.yash.tams.exception.TamsException;
import com.yash.tams.model.User;
import com.yash.tams.wrapper.SubmissionWrapper;

public interface SubmissionService {
	public List<SubmissionWrapper> getSubmissionsByAllTrainees(int trainerid);
	public List<SubmissionWrapper> getTraineeSubmissions(int traineeid);
	public void updateSubmissionStatus(int submissionid, String status);
	public List<SubmissionWrapper> filterSubmission(int trainerid, String traineeName, String assignmentName);
}
