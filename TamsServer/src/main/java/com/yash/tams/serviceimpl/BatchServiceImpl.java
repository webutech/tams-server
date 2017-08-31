/**
 * Implementation of the Batch Service Interface Layer.
 * Access the Service Layer and business Logic Goes Here
 * @author Anuradha
 *
 */
package com.yash.tams.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tams.dao.BatchDao;
import com.yash.tams.exception.TamsException;
import com.yash.tams.model.Batch;
import com.yash.tams.service.BatchService;



@Service
public class BatchServiceImpl implements BatchService {

	
	
	@Autowired
	BatchDao batchDao;
	
	
	/*
	 * Service implementation method to add a new batch. Calls BatchDaoImpl's addBatch() method 
	 * to achieve task. Accepts Batch object as an argument, receives object from controller, 
	 * pass it on to BatchDaoImpl return nothing
	 * @Batch batch
	 * */
	@Override
	public void addBatch(Batch batch) {
		batchDao.addBatch(batch);

	}

	/*
	 * Service implementation method to delete an existing batch. 
	 * Calls BatchDaoImpl's deleteBatch() method to achieve task. 
	 * Accepts Batch id as an argument from controller, return nothing
	 * @id
	 * */
	@Override
	public void deleteBatch(int id) {
		batchDao.deleteBatch(id);

	}

	
	/*
	 * Service implementation method to edit an existing batch. 
	 * Calls BatchDaoImpl's editBatch() method to achieve task. 
	 * Accepts Batch object as an argument from controller, return nothing
	 * @Batch batch
	 * */
	@Override
	public void editBatch(Batch batch) {
		batchDao.editBatch(batch);

	}

	/*
	 * Service implementation method to list all existing batches from database.
	 *  Calls BatchDaoImpl's ListBatch() method to achieve task. 
	 *  Accepts no argument, return List of batches to calling controller
	 * @return batches
	 * */
	@Override
	public List<Batch> getBatches() throws TamsException {
		
		return batchDao.getBatches();
	}

}
