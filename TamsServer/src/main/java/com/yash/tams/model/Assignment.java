package com.yash.tams.model;

import java.util.Date;

public class Assignment {
	/**
	 * This is the primary key id for the assignment model
	 */
	private int id;
	/**
	 * this is the name of the assignment
	 */
	private String name;
	/**
	 * this is the description of the assignment
	 */
	private String description;
	/**
	 * this is the due date of the assignment
	 */
	private Date dueDate;
	/**
	 * this is the batch id that the assignment is assigned to 
	 */
	private int batchid;
	/**
	 * this is the user id that the assignment is assigned to
	 */
	private int userid;
	/**
	 * this is the id of the person that created the assignment
	 */
	private int createdBy;
	/**
	 * this is the date the assignment was created 
	 */
	private Date createdDate;
	/**
	 * this is the id of the person who last modified the assignment
	 */
	private int modifiedBy;
	/**
	 * this is the date the assignment was last modified
	 */
	private Date modifiedDate;
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
