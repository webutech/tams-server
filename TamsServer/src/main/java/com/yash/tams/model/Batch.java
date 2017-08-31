/**
 * 
 */
package com.yash.tams.model;

import java.util.Date;

/**
 * This is the Batch model/pojo class for the application.
 * @author Anuradha
 *
 */
public class Batch {
	
	/**
	 * This is the primary key of Batch object & auto-incremented
	 */
	private int id;
	
	/**
	 * Represents the Name of the Batch
	 */
	private String batchName;
	
	/**
	 * Represents the id of a user who created the batch
	 */
	private int createdBy;
	
	
	/**
	 * Represents the date when this batch is created 
	 */
	private Date createDate;
	
	
	/**
	 * Represents the id of a user who modified the batch
	 */
	private int modifiedBy;
	
	
	/**
	 * Represents the date when this batch is modified 
	 */
	private Date modifiedDate;
	
	/**
	 * StatusId Represents whether a batch is active or not, 1 for active & 2 for inactive 
	 */
	private int statusId;
	
	
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	/**
	 * Represents the status of the Batch, whether it is active (1) or inactive(2)
	 */
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBatchName() {
		return batchName;
	}

	

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
}
