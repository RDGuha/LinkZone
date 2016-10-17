package com.niit.backend.dao;

import com.niit.backend.entity.Users;

public interface UserDAO {

	void saveOrUpdateUser(Users user);
	
	void deleteUser(String email);
	
	Users getUser(String userId);
	
}
