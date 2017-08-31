package com.yash.tams.dao;

import java.util.List;

import com.yash.tams.exception.TamsException;
import com.yash.tams.model.Assignment;


public interface AssignmentDao {
	
	/**
	 * Returns all Assignments from the database
	 * @return
	 * @throws TamsException
	 */
	public List<Assignment> getAssignments() throws TamsException;
	/**
	 * Returns an assignment by the id number
	 * @param id
	 * @return
	 * @throws TamsException
	 */
	public Assignment getAssignmentById(int id) throws TamsException;
	
	/**
	 * Deletes an assignment from the database using the id as the key
	 * @param id
	 * @return
	 */
	public int deleteAssignment(int id) throws TamsException;
	
	/**
	 * Update an assignment in the database
	 * @param assignment
	 * @return
	 */
	public int updateAssignment(Assignment assignment) throws TamsException;
	
	/**
	 * Adds an assignment to the database
	 * @param assignment
	 * @return
	 */
	public int addAssignment(Assignment assignment) throws TamsException;
	/**
	 * Assigns an assignment to a batch
	 * @param assignmentId
	 * @param batchId
	 * @return
	 */
	public int addAssignmentToBatch(int assignmentId, int batchId) throws TamsException;
	/**
	 * Assign an assignment to a User
	 * @param assignmentId
	 * @param userId
	 * @return
	 */
	public int addAssignmentToUser(int assignmentId, int userId) throws TamsException;
}
