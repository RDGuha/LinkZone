package com.niit.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.niit.backend.dao.UserDetailDAO;
import com.niit.backend.entity.UserDetail;
import com.niit.backend.model.ProfileModel;



@RestController
public class UserController {

	@Autowired
	UserDetail userDetail;

	@Autowired
	UserDetailDAO userDetailDAO;

	@GetMapping("/users/")
	public ResponseEntity<List<UserDetail>> getAllUsers() {
		List<UserDetail> listOfUsers = userDetailDAO.listUserDetails();
		if (listOfUsers == null) {
			return new ResponseEntity<List<UserDetail>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UserDetail>>(listOfUsers, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDetail> getUser(@PathVariable("userId") String userId) {
		userDetail = userDetailDAO.getUserDetail(userId);
		if (userDetail == null) {
			return new ResponseEntity<UserDetail>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDetail>(userDetail, HttpStatus.OK);
	}

	@PutMapping("/user/{userId}")
	public ResponseEntity<ProfileModel> updateStatus(@PathVariable("userId") String userId,
			@RequestBody ProfileModel profileModel) {
		System.out.println(profileModel.getUserStatus());
		userDetail = userDetailDAO.getUserDetail(userId);
		if (userDetail == null)
			return new ResponseEntity<ProfileModel>(HttpStatus.NOT_FOUND);
		userDetail.setUserStatus(profileModel.getUserStatus());
		userDetailDAO.saveOrUpdateUserDetail(userDetail);
		return new ResponseEntity<ProfileModel>(profileModel, HttpStatus.OK);
	}

	@PostMapping("/user/upload/{userId}")
	public ResponseEntity<Void> uploadProfilePicture(@PathVariable(value="user") String userId,
			@RequestParam(value="image") MultipartFile profilePiture) {
		System.out.println(userId);
		String path  = "E:\\beone\\users\\";
		//FileUpload.uploadImage(path, profilePiture, userId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
