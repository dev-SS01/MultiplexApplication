package com.multiplex.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.dto.UserDTO;
import com.multiplex.entities.User;
import com.multiplex.exception.UserAlreadyExistsException;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.services.UserServices;

@RestController
@ResponseBody
public class UserController {

	@Autowired
	private UserServices userServices;

	@GetMapping(value="/usertable")
	public ResponseEntity<List<UserDTO>> getUsers() throws UserNotFoundException{
		List<UserDTO> userList=userServices.getUsers();
		return new ResponseEntity<List<UserDTO>>(userList, HttpStatus.OK);
	}
	
@PostMapping(value="/usertable")
	public ResponseEntity<String> addUser(@RequestBody UserDTO user) throws UserAlreadyExistsException{
		User userId=userServices.addUser(user);
		return new ResponseEntity<String>("API.INSERT_CREATED", HttpStatus.CREATED);
	}

@GetMapping(value="/usertable/{userId}")
public ResponseEntity<UserDTO> getUserbyId(@PathVariable Integer userId) throws UserNotFoundException{
	UserDTO user=userServices.getUserById(userId);
	return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
}


@DeleteMapping(value="/usertable/{userId}")
public ResponseEntity deleteUserById(@PathVariable Integer userId) throws UserNotFoundException{
	userServices.deleteUser(userId);
	return new ResponseEntity<String>("API.DELETE_SUCCESS", HttpStatus.OK);
}


@GetMapping("/usertable/u/{userName}")
public ResponseEntity getUserByName(@PathVariable String userName) throws UserNotFoundException{
	return new ResponseEntity(userServices.getUserByName(userName), HttpStatus.FOUND);
}

@PutMapping(value="/usertable/u/{userId}")
public ResponseEntity updateUserByEmailId(@PathVariable Integer userId, @RequestBody UserDTO user) throws UserNotFoundException{
	userServices.updateUserByEmailId(userId, user.getEmailId());
	return new ResponseEntity("API.UPDATE_SUCCESS", HttpStatus.ACCEPTED);
}

@PutMapping(value="/usertable/ut/{userId}")
public ResponseEntity updateUserByName(@PathVariable Integer userId, @RequestBody UserDTO user) throws UserNotFoundException{
	userServices.updateUserByEmailId(userId, user.getUserName());
	return new ResponseEntity("API.UPDATE_SUCCESS", HttpStatus.ACCEPTED);
}
}
