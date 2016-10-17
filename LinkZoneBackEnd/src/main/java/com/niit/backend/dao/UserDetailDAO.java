package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.entity.UserDetail;



public interface UserDetailDAO {

	void saveOrUpdateUserDetail(UserDetail userDetail);
	
	void deleteUserDetail(String userId);
	
	UserDetail getUserDetail(String userId);
	
	List<UserDetail> listUserDetails();
	
	UserDetail getUserByEmail(String email);
	
	UserDetail checkUser(String email,String password);
}
