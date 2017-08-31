/**
 * 
 */
package com.yash.tams.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yash.tams.model.Batch;

/**
 * 
 *  RowMapper for the Batch Class, Use this with the jdbc template to 
 *  get data from the database & convert resultset object to Batch object
 * @author Anuradha
 *
 */
public class BatchRowMapper implements RowMapper<Batch> {

	/**
	 * Sets the fields of the Batch Object for each row of resultSet that is returned
	 * from the database & returns batch object as a result
	 * @resultSet
	 * @rowNum
	 */
	@Override
	public Batch mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Batch batch = new Batch();
		batch.setBatchName(resultSet.getString("batchName"));
		batch.setCreateDate(resultSet.getDate("createdDate"));
		batch.setCreatedBy(resultSet.getInt("createdBy"));
		batch.setModifiedBy(resultSet.getInt("modifiedBy"));
		batch.setModifiedDate(resultSet.getDate("modifiedDate"));
		batch.setStatusId(resultSet.getInt("statusId"));
		return batch;
	}

}
