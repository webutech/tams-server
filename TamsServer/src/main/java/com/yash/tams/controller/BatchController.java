package com.yash.tams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.tams.service.BatchService;
import com.yash.tams.urls.TamsServerUrls;
import com.yash.tams.exception.TamsException;
import com.yash.tams.model.Batch;

@RestController
public class BatchController {
	/**
	 * Batchservice impl object for batch controller
	 */
	@Autowired
	BatchService batchservice;

	/**
	 * This method will add the batch details into batches table in database.
	 * RequestBody will convert the JSON request into Java Object
	 * 
	 * @param batch
	 */
	@RequestMapping(value = TamsServerUrls.BATCH, method = RequestMethod.POST)
	public void Batch(@RequestBody Batch batch) {
		batchservice.addBatch(batch);
	}

	/**
	 * This method will edit details of batch in database
	 * 
	 * @param batch
	 */

	@RequestMapping(value = TamsServerUrls.EDIT_BATCH, method = RequestMethod.POST)
	public void editBatch(@RequestBody Batch batch) {
		batchservice.editBatch(batch);
	}

	/**
	 * Deletes the batch by its id from the database
	 * 
	 * @param id
	 */
	@RequestMapping(value = TamsServerUrls.DELETE_BATCH, method = RequestMethod.POST)
	public void deleteBatch(@PathVariable String id) {
		batchservice.deleteBatch(Integer.parseInt(id));
	}

	/**
	 * Returns the list of batches from the database
	 * @throws TamsException 
	 * 
	 */
	@RequestMapping(value = TamsServerUrls.LIST_BATCHES)
	public void getBatches() throws TamsException {
		List<Batch> listofbatches = batchservice.getBatches();

	}

}
