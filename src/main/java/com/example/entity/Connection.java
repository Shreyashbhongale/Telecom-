package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Connection {

	@Id
	private String con_id;
	private String con_name; 
	private String con_status;    
	private String con_plan;
	private long   con_ref_no;
	
	@JsonIgnore
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@Column(name = "userId")
	private String userId;
	
	public Connection() {
		super();
	}
	public Connection(String con_id, String con_name, String con_status, String con_plan, long con_ref_no) {
		super();
		this.con_id = con_id;
		this.con_name = con_name;
		this.con_status = con_status;
		this.con_plan = con_plan;
		this.con_ref_no = con_ref_no;
	}
	public String getCon_id() {
		return con_id;
	}
	public void setCon_id(String con_id) {
		this.con_id = con_id;
	}
	public String getCon_name() {
		return con_name;
	}
	public void setCon_name(String con_name) {
		this.con_name = con_name;
	}
	public String getCon_status() {
		return con_status;
	}
	public void setCon_status(String con_status) {
		this.con_status = con_status;
	}
	public String getCon_plan() {
		return con_plan;
	}
	public void setCon_plan(String con_plan) {
		this.con_plan = con_plan;
	}
	public long getCon_ref_no() {
		return con_ref_no;
	}
	public void setCon_ref_no(long con_ref_no) {
		this.con_ref_no = con_ref_no;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Connection [con_id=" + con_id + ", con_name=" + con_name + ", con_status=" + con_status + ", con_plan="
				+ con_plan + ", con_ref_no=" + con_ref_no + "]";
	}
	
	
	
	
}
