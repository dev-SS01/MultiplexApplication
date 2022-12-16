package com.multiplex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.multiplex.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.userName=:userName")
public List<User> findUserByName(@Param(value="userName")String userName);
	@Query("select u from User u where u.emailId=:emailId")
	public List<User> findByEmailId(@Param(value="emailId")String userName);
}
