/**
 * 
 */
package com.yash.tams.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yash.tams.exception.TamsException;
import com.yash.tams.model.Batch;
import com.yash.tams.model.User;

/**
 * This is the Dao Interface for the Batch model.
 * Provides list of unimplemented methods to perform CRUD operations on Batch Model
 * @author Anuradha
 *
 */


public interface BatchDao {
	/*
	 * public method to create a new batch in database. 
	 * Accepts Batch object as argument and returns nothing
	 * @Batch batch
	 * */
	public void addBatch(Batch batch);
	
	
	
	/*
	 * public method to deletes an existing batch form database. The id
	 * is supplied as an arguments and returns nothing
	 * @id
	 * */
	public void deleteBatch(int id);
	
	
	/*
	 * public method to edit an existing batch form database. The Batch object 
	 * is supplied as an arguments and returns nothing
	 * @Batch batch
	 * */
	public void editBatch(Batch batch);
	
	
	/**
	 * Returns a List of all Batches in the database
	 * Or returns null if there is an error fetching from the database
	 * @return
	 */
	public List<Batch> getBatches() throws TamsException;
	
}
