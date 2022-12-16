package com.multiplex;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multiplex.entities.User;
import com.multiplex.repository.UserRepository;

@SpringBootTest
class MultiplexProjectApplicationTests {

	@Autowired
	private UserRepository userRespository;
	
	@Test
	public void addUser(){
		User user=new User(2, "Shubham", "7898456786", "shubh.am@gmail.com", "Password");
		userRespository.save(user);
		assertNotNull(userRespository.findById(2).get());
	}
	

}
