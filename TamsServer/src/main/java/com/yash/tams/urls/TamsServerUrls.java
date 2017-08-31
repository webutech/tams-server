package com.yash.tams.urls;



public class TamsServerUrls {

	//User Urls
	
	public static final String USERS = "/users";
	public static final String USERS_BY_ID = "/users/{id}";
	public static final String EDIT_PASSWORD = "/editPassword/{id}";
	public static final String USER_AUTHENTICATE = "/users/{login}/{password}";
	//Batch URls
		public static final String BATCH="/addBatch";
		public static final String EDIT_BATCH="/editBatch";
		public static final String DELETE_BATCH="/deleteBatch/{id}";
		public static final String LIST_BATCHES="/listBatches";
	
	//Assignment URLs
	public static final String ASSIGNMENTS = "/assignments";
	public static final String ASSIGNMENTS_BY_ID = "/assignments/{id}";
	public static final String ASSIGNMENTS_ASSIGN_BATCH = "/assignments/batch";
	public static final String ASSIGNMENTS_ASSIGN_USER = "/assignments/user";
	
}
