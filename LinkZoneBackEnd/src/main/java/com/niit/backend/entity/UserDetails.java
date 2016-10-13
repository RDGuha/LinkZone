package com.niit.backend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class UserDetails {
	@Id
	private String userDetails_id;
	private String userName;
	private String password;
	private String email;
	private String gender;
	private String phoneNo;
	private String Enabled;
	private String dateOfBirth;
	private String status;
	private String is_notify;
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getUserDetails_id() {
		return userDetails_id;
	}
	public void setUserDetails_id(String userDetails_id) {
		this.userDetails_id = userDetails_id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getEnabled() {
		return Enabled;
	}
	public void setEnabled(String enabled) {
		Enabled = enabled;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIs_notify() {
		return is_notify;
	}
	public void setIs_notify(String is_notify) {
		this.is_notify = is_notify;
	}
	public UserDetails(){
		this.userDetails_id="USID"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	

}
