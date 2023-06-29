package com.example.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	private String user_id;
	private String name;
	private String email;
	private long contact_No;
	
	@OneToMany(mappedBy = "user")
	List<Connection> connectionList;
	
	public User() {
		super();
	}
	public User(String user_id, String name, String email, long contact_No) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.contact_No = contact_No;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact_No() {
		return contact_No;
	}
	public void setContact_No(long contact_No) {
		this.contact_No = contact_No;
	}
	public List<Connection> getConnectionList() {
		return connectionList;
	}
	public void setConnectionList(List<Connection> connectionList) {
		this.connectionList = connectionList;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", contact_No=" + contact_No + "]";
	}
	
}
