package com.yash.tams.model;

import java.util.Date;

public class Batch {

	/**
	 * Id is a field which helps us uniquely identify a batch
	 */
	private int id;
	/**
	 * Represents the name of the batch
	 */
	private String batchName;

	/**
	 * Represents the userid of the user 
	 * who created the batch
	 */
	private int createdBy;
	/**
	 * Represents the userid of the 
	 * user who modified the batch details
	 */
	private int modifiedBy;
	/**
	 * Represents the created Date
	 */
	private Date createdDate;
	/**
	 * Represents the ModifiedDate
	 */
	private Date ModifiedDate;
	
	//private int statusId;

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

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}

}
