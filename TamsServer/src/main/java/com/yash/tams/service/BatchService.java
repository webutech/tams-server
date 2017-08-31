package com.yash.tams.service;


import java.util.List;

import com.yash.tams.model.Batch;


public interface BatchService {
	
	public void addBatch(Batch batch);
	public void editBatch(Batch batch);
	public void deleteBatch(int id);
	public  List<Batch> getBatches();

}
