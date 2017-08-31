package com.yash.tams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tams.model.Assignment;
import com.yash.tams.service.AssignmentService;
import com.yash.tams.urls.TamsServerUrls;

/**
 * Rest Controller for the assignments
 * 
 * @author Brian Sutton
 *
 */
@RestController
public class AssignmentController {
	/**
	 * Assignment Service for this assignment controller
	 */
	@Autowired
	AssignmentService assignmentService;
	/**
	 * returns a list of all assignments
	 * 
	 * @return
	 */
	@CrossOrigin("*")
	@RequestMapping(value = TamsServerUrls.ASSIGNMENTS, method = RequestMethod.GET)
	public List<Assignment> getAssignments() {
		
		return assignmentService.getAssignments();

	}
	/**
	 * Controller to add an assignment to the database returns 1 for success 0
	 * for fail
	 * 
	 * @param assignment
	 * @return
	 */
	@CrossOrigin("*")
	@RequestMapping(value = TamsServerUrls.ASSIGNMENTS, method = RequestMethod.POST, consumes = "application/json")
	public int addAssignment(@RequestBody Assignment assignment) {

		return assignmentService.addAssignment(assignment);
	}
	/**
	 * Upate an assignment from the database
	 * 
	 * @param assignment
	 * @return
	 */
	@CrossOrigin("*")
	@RequestMapping(value = TamsServerUrls.ASSIGNMENTS, method = RequestMethod.PUT, consumes = "application/json")
	public int updateAssignment(@RequestBody Assignment assignment) {
		return assignmentService.updateAssignment(assignment);
	}
	/**
	 * Delete an assignment from the database
	 * @param id
	 * @return
	 */
	@CrossOrigin("*")
	@RequestMapping(value = TamsServerUrls.ASSIGNMENTS_BY_ID, method = RequestMethod.DELETE, consumes = "application/json")
	public int deleteAssignment(@PathVariable int id) {
		return assignmentService.deleteAssignment(id);

	}
	/**
	 * Gets and returns an assignment by id
	 * @param id
	 * @return
	 */
	@CrossOrigin("*")
	@RequestMapping(value = TamsServerUrls.ASSIGNMENTS_BY_ID, method = RequestMethod.GET, consumes = "application/json")
	public Assignment getAssignmentById(@PathVariable int id) {
		return assignmentService.getAssignmentById(id);

	}
	/**
	 * Assign an assignment to a Batch
	 * @param id
	 * @param batchOrUser
	 * @param bouId
	 * @return
	 */
	@CrossOrigin("*")
	@RequestMapping(value = TamsServerUrls.ASSIGNMENTS_ASSIGN_BATCH, method = RequestMethod.PUT, consumes = "application/json")
	public int assignAssignmentToBatch(@RequestBody Assignment assignment){
	
			return assignmentService.assignAssignmentToBatch(assignment.getId(), assignment.getBatchid());
		
	}
	/**
	 * Assign an assignment to a User
	 * @param assignment
	 * @return
	 */
	@CrossOrigin("*")
	@RequestMapping(value = TamsServerUrls.ASSIGNMENTS_ASSIGN_USER, method = RequestMethod.PUT, consumes = "application/json")
	public int assignAssignmentToUser(@RequestBody Assignment assignment){
			return assignmentService.assignAssignmentToUser(assignment.getId(), assignment.getUserid());
		
	}
	
}
