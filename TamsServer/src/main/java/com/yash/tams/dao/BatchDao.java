package com.yash.tams.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yash.tams.model.Batch;

@Repository
public interface BatchDao {
	
	public void addBatch(Batch batch);
	
	public void deleteBatch(int id);
	
	public void editBatch(Batch batch);
	
	public List<Batch> getBatches();

}
