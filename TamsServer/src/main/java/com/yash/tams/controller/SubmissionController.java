package com.yash.tams.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tams.service.SubmissionService;
import com.yash.tams.wrapper.SubmissionWrapper; 

@RestController
public class SubmissionController {
	
	@Autowired
	SubmissionService submissionService;
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping("/AllTraineeSubmissions")
	public List<SubmissionWrapper> getAllSubmissions(HttpServletResponse response) {
		
		response.setStatus(200);
		response.addHeader("ok", "true");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");
		response.addHeader("content-type", "application/json");
		response.setContentType("application/json");
		
		httpSession.setAttribute("trainerid", 5);
		Integer trainerid=(Integer)httpSession.getAttribute("trainerid");
		System.out.println(trainerid);
		return submissionService.getSubmissionsByAllTrainees(trainerid);
		
	}
	
	@RequestMapping("/Submissions")
	public List<SubmissionWrapper> getTraineeSubmissions(HttpServletResponse response) {
		
		response.setStatus(200);
		response.addHeader("ok", "true");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");
		response.addHeader("content-type", "application/json");
		response.setContentType("application/json");
		
		httpSession.setAttribute("traineeid", 3);
		Integer traineeid=(Integer)httpSession.getAttribute("traineeid");
		System.out.println(traineeid);
		return submissionService.getTraineeSubmissions(traineeid);
		
	}
	
	
	@RequestMapping(value="/UpdateSubmission", method=RequestMethod.PUT, consumes = "application/json")
	public void updateSubmissionStatus(HttpServletResponse response, 
										@RequestBody SubmissionUpdate submissionUpdate) {
		
		int subid = submissionUpdate.getSubmissionid();
		String substatus = submissionUpdate.getStatus();
		Integer traineeid=(Integer)httpSession.getAttribute("traineeid");
		System.out.println(traineeid);
		submissionService.updateSubmissionStatus(subid, substatus);
		
	}
	
	
	@RequestMapping("/FilterSubmissions")
	public List<SubmissionWrapper> filterSubmissions(HttpServletResponse response,
										@RequestBody FilterSubmissionDetails filterSubmissionDetails) {
		
		response.setStatus(200);
		response.addHeader("ok", "true");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");
		response.addHeader("content-type", "application/json");
		response.setContentType("application/json");
		
		httpSession.setAttribute("trainerid", 4);
		String traineeName=filterSubmissionDetails.getTraineeName();
		String assignmentName=filterSubmissionDetails.getAssignmentName();
		Integer trainerid=(Integer)httpSession.getAttribute("trainerid");
		System.out.println(trainerid);
		return submissionService.filterSubmission(trainerid, traineeName, assignmentName);
		
	}
	
	
}

class SubmissionUpdate {
	int submissionid;
	String status;
	public SubmissionUpdate(){
		
	}
	public int getSubmissionid() {
		return submissionid;
	}
	public void setSubmissionid(int submissionid) {
		this.submissionid = submissionid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}


class FilterSubmissionDetails{
	String traineeName;
	String assignmentName;
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
	
}
