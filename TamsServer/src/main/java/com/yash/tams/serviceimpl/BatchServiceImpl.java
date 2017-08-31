package com.yash.tams.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tams.dao.BatchDao;
import com.yash.tams.model.Batch;
import com.yash.tams.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	BatchDao batchdao;


	@Override
	public void addBatch(Batch batch) {
		batchdao.addBatch(batch);

	}


	@Override
	public void editBatch(Batch batch) {
		batchdao.editBatch(batch);
	}


	@Override
	public void deleteBatch(int id) {
		batchdao.deleteBatch(id);
	}


	@Override
	public List<Batch> getBatches() {
		return batchdao.getBatches();
	}

}
