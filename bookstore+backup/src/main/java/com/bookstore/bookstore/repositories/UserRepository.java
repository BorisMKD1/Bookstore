package com.bookstore.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByName(String name);

	List<User> findByLastName(String lastName);
	
	User findByEmail(String email);
	


}
