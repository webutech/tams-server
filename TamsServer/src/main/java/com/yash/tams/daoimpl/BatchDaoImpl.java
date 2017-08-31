package com.yash.tams.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yash.tams.dao.BatchDao;
import com.yash.tams.model.Batch;

@Repository
public class BatchDaoImpl implements BatchDao{
	
	

	@Override
	public void addBatch(Batch batch) {
		
	}

	@Override
	public void deleteBatch(int id) {
		System.out.println(id);
	}

	@Override
	public void editBatch(Batch batch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Batch> getBatches() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
