package com.yash.tams.service;

import java.util.List;

import com.yash.tams.model.Assignment;

/**
 * This is the Service interface for the assignment class
 * @author Brian Sutton
 *
 */
public interface AssignmentService {

	/**
	 * Returns the list of all assignments
	 * @return
	 */
	public List<Assignment> getAssignments();
	/**
	 * adds an assignment to the database
	 * @param assignment
	 * @return
	 */
	public int addAssignment(Assignment assignment);
	/**
	 * updates an assignment in the database
	 * @param assignment
	 * @return
	 */
	public int updateAssignment(Assignment assignment);
	/**
	 * Deletes an assignment in the database
	 * @param id
	 * @return
	 */
	public int deleteAssignment(int id);
	/**
	 * Gets an assignment by id
	 * @param id
	 * @return
	 */
	public Assignment getAssignmentById(int id);
	/**
	 * Assigns the assignment to the batch
	 * @param id
	 * @param batchId
	 * @return
	 */
	public int assignAssignmentToBatch(int id, int batchId);
	/**
	 * Assigns the assignment to a user
	 * @param id
	 * @param UserId
	 * @return
	 */
	public int assignAssignmentToUser(int id, int UserId);
	
}
