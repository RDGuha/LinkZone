package com.niit.backend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="users")
public class User {
    @Id
	private String user_id;
	private String userName;
	private String password;
	private boolean enabled;
	private String userDetails_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getUserDetails_id() {
		return userDetails_id;
	}
	public void setUserDetails_id(String userDetails_id) {
		this.userDetails_id = userDetails_id;
	}
	public User(){
		this.user_id="USR"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
}
