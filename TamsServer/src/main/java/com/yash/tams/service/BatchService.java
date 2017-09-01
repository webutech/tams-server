/**
 * This is the Service Interface for the Batch model.
 * Provides list of unimplemented methods to perform CRUD operations on Batch Model
 * along with required business logic
 * @author Anuradha
 *
 */

package com.yash.tams.service;

import java.util.List;

import com.yash.tams.exception.TamsException;
import com.yash.tams.model.Batch;



public interface BatchService {
	
	/*
	 * Service method to add a new batch. Calls BatchDaoImpl's addBatch() method 
	 * to achieve task. Accepts Batch object as an argument, return nothing
	 * @Batch batch
	 * */
	public void addBatch(Batch batch);
	
	/*
	 * Service method to delete an existing batch. Calls BatchDaoImpl's deleteBatch() method 
	 * to achieve task. Accepts Batch id as an argument, return nothing
	 * @id
	 * */
	public void deleteBatch(int id);
	
	
	/*
	 * Service method to edit an existing batch. Calls BatchDaoImpl's editBatch() method 
	 * to achieve task. Accepts Batch object as an argument, return nothing
	 * @Batch batch
	 * */
	public void editBatch(Batch batch);
	
	
	/*
	 * Service method to list all existing batches from database. Calls BatchDaoImpl's ListBatch() method 
	 * to achieve task. Accepts no argument, return List of batches
	 * @return batches
	 * */
	public List<Batch> getBatches() throws TamsException;

}
