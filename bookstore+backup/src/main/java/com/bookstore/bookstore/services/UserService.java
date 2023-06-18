package com.bookstore.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bookstore.bookstore.entities.User;
import com.bookstore.bookstore.exception.BookstoreException;
import com.bookstore.bookstore.repositories.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getUserByName(String name) {
		return userRepository.findByName(name);
	}

	public List<User> getUserByLastName(String lastName) {
		return userRepository.findByLastName(lastName);
	}

	public User getUserByEmail(String email) {

		return userRepository.findByEmail(email);
	}
	
	public User addUser(User user) {
		User tempUser = getUserByEmail(user.getEmail());
		if (tempUser != null) {
			throw new BookstoreException("EMAIL IS ALREADY IN USE");
		}

		return userRepository.save(user);
	}

	

	public User editUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}



	public List<User> findAll() {
		return userRepository.findAll(); //a ilo?
	}

	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}

}
