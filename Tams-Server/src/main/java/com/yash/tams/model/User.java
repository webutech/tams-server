package com.yash.tams.model;

/**
 * This is the User model/pojo class for the application.
 * Used to pass data through the application
 * 
 * @author Brian Sutton
 *
 */
public class User {

	/**
	 * This is the primary key of this object, auto-incremented
	 */
	private int id;
	/**
	 * Represents the Name of the User
	 */
	private String name;
	/**
	 * The login of the User
	 */
	private String login;
	/**
	 * Phone Number of the User
	 */
	private String contact;
	/**
	 * Password of the user
	 */
	private String password;
	/**
	 * The email address of the user
	 */
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
