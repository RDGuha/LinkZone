package com.niit.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.backend.dao.UserAuthoritiesDAO;
import com.niit.backend.dao.UserDAO;
import com.niit.backend.dao.UserDetailDAO;
import com.niit.backend.entity.UserAuthorities;
import com.niit.backend.entity.UserDetail;
import com.niit.backend.entity.Users;
import com.niit.backend.model.LoginModel;
import com.niit.backend.model.UserToSend;
import com.niit.backend.model.ValidUserModel;
import com.niitbackend.utitlity.IdGenerator;



@RestController
public class LoginController {

	@Autowired
	UserDetailDAO userDetailDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserAuthoritiesDAO userAuthoritiesDAO;

	@Autowired
	UserDetail userDetail;

	@Autowired
	UserAuthorities userAuthorities;

	@Autowired
	Users users;

	/*private EmailSender emailsender = new EmailSender();*/

	@PostMapping("/register")
	public ResponseEntity<Void> registerUser(@RequestBody LoginModel loginModel, UriComponentsBuilder ucBuilder) {

		if (userDetailDAO.getUserByEmail(loginModel.getRegisterEmail()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		userDetail = new UserDetail();
		userDetail.setUserId(IdGenerator.generateId("USR"));
		userDetail.setStatus('N');
		userDetail.setEmail(loginModel.getRegisterEmail());
		userDetail.setName(loginModel.getRegisterName());
		userDetail.setGender(loginModel.getRegisterGender());
		userDetail.setPassword(loginModel.getRegisterPassword());
		userDetailDAO.saveOrUpdateUserDetail(userDetail);

		users.setUserDetail(userDetail);
		users.setEmail(userDetail.getEmail());
		users.setPassword(userDetail.getPassword());
		users.setEnabled(true);
		userDAO.saveOrUpdateUser(users);

		userAuthorities.setUserDetail(userDetail);
		userAuthorities.setAuthority(loginModel.getRegisterRole());
		userAuthorities.setEmail(userDetail.getEmail());
		userAuthoritiesDAO.saveOrUpdateUserAuthority(userAuthorities);

		String message = "Hello " + userDetail.getName() + " you're successfully registered with us, Thanks !";

		// emailsender.sendEmail(userDetail.getEmail(), "Registration Successfull", message);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ucBuilder.path("/register/{userId}").buildAndExpand(userDetail.getUserId()).toUri());
		return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<UserToSend> isValidUser(@RequestBody ValidUserModel validUser) {

		System.out.println(validUser.getEmail() + "   " + validUser.getPassword());
		if (userDetailDAO.checkUser(validUser.getEmail(), validUser.getPassword()) == null) {
			return new ResponseEntity<UserToSend>(HttpStatus.NOT_FOUND);
		}
		userDetail = userDetailDAO.checkUser(validUser.getEmail(), validUser.getPassword());
		
		UserToSend userToSend = new UserToSend();
		userToSend.setUserId(userDetail.getUserId());
		userToSend.setEmail( userDetail.getEmail());
		int roleValue = 0;
		switch( userAuthoritiesDAO.getUserAuthority(userDetail.getUserId()).getAuthority()){
		case "ROLE_STUDENT":
			roleValue = 1;
			break;
		case "ROLE_ALUMNI":
			roleValue = 2;
			break;
		case "ROLE_EMPLOYEE":
			roleValue = 3;
			break;		
		}
		userToSend.setRole(roleValue);
		userDetail.setStatus('A');
		userDetailDAO.saveOrUpdateUserDetail(userDetail);
		
		return new ResponseEntity<UserToSend>(userToSend,HttpStatus.OK);

	}
	
	@PutMapping("/logout/{userId}")
	public ResponseEntity<Void> logout(@PathVariable("userId") String userId){
		if(userId !=null){
		userDetail = userDetailDAO.getUserDetail(userId);
		userDetail.setStatus('N');
		userDetailDAO.saveOrUpdateUserDetail(userDetail);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	
	

	/*
	 * @GetMapping("/login") public ResponseEntity<Void>
	 * login(@RequestParam(value="error",required=false)String error){
	 * System.out.println("In login"); if(error!=null) {
	 * System.out.println("In login unauthorized"); return new
	 * ResponseEntity<Void>(HttpStatus.UNAUTHORIZED); } return new
	 * ResponseEntity<Void>(HttpStatus.OK); }
	 */
}
