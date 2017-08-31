package com.yash.tams.wrapper;

import java.util.Date;

public class SubmissionWrapper{
	int id;
	String traineeName;
	String assignmentName;
	String remarks;
	Date dateOfSubmission;
	String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getDateOfSubmission() {
		return dateOfSubmission;
	}
	public void setDateOfSubmission(Date dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

