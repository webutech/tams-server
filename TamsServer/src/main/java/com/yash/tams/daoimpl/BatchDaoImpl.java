package com.yash.tams.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.tams.dao.BatchDao;
import com.yash.tams.exception.TamsException;
import com.yash.tams.model.Batch;
import com.yash.tams.rowmapper.BatchRowMapper;


/**
 * Implementation of the Batch Dao Layer.
 * Access the database Here to perform CRUD operations on Batch model
 * @author Anuradha
 *
 */

@Repository
public class BatchDaoImpl implements BatchDao {
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	

	/*private Batch batch;

	public BatchDaoImpl() {
		batch = new Batch();
	}*/

	public DataSource getDataSource() {
		return dataSource;
	}

	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(this.dataSource);
	}
	
	
/*
 * public method to create a new batch in database. 
 * Accepts Batch object as an argument and returns nothing
 * @Batch batch
 * */
	@Override
	public void addBatch(Batch batch) {
		String sql = "INSERT INTO batches (batchName, createdBy, createdDate,modifiedBy,modifiedDate,statusId) VALUES (?, ?, ?, ?,?,?)";
		
		jdbcTemplate.update(sql,new Object[]{ batch.getBatchName(),batch.getCreatedBy(),batch.getCreateDate(),batch.getModifiedBy(),batch.getModifiedDate(), batch.getStatusId()});
		
		System.out.println("Operation performed successfully");
		
	}

	/*
	 * public method to deletes an existing batch form database. The batch id
	 * is supplied as an arguments and returns nothing
	 * @id
	 * */
	@Override
	public void deleteBatch(int id) {
		jdbcTemplate.update("delete from batches where id =?",new Object[]{id});
		System.out.println("Task deleted");

	}

	/*
	 * public method to edit an existing batch form database. The Batch object 
	 * is supplied as an arguments and returns nothing
	 * @Batch batch
	 * */
	@Override
	public void editBatch(Batch batch) {
		

		String sql = "UPDATE  batches SET batchName=?, createdBy=?, createdDate=?,modifiedBy=?,modifiedDate=?,statusId=? where id=?";
		
		jdbcTemplate.update(sql,new Object[]{ batch.getBatchName(),batch.getCreatedBy(),batch.getCreateDate(),batch.getModifiedBy(),batch.getModifiedDate(), batch.getId(),batch.getStatusId()});
		
		System.out.println("Operation performed successfully");
	}

	/*
	 * public method to List  existing batches form database. 
	 * Returns List of Batches
	 * @return 
	 * */
	@Override
	public List<Batch> getBatches() throws TamsException {
		
		
		
		try{
			return jdbcTemplate.query("select * from batches", new BatchRowMapper());
			}catch (Exception e) {
				e.printStackTrace();
				throw new TamsException(e.getMessage());
			}
		

	}

}
