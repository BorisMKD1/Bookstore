package com.bookstore.bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.entities.User;
import com.bookstore.bookstore.services.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/byId/{id}")
	public User getUserByName(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/byName/{name}")
	public List<User> getUserByName(@PathVariable("name") String name) {
		return userService.getUserByName(name);
	}

	@GetMapping("/byLastName/{lastName}")
	public List<User> getUserByLastName(@PathVariable("lastName") String lastName) {
		return userService.getUserByLastName(lastName);
	}

	@GetMapping("/byEmail/{email}")
	public User getUserByEmail(@PathVariable("email") String email) {
		return userService.getUserByEmail(email);
	}
	
	@GetMapping("/users")
	List<User> getAllUsers(){
		return userService.findAll();//a ilo
	}

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping("/editUser")
	public User editUser(@RequestBody User user) {
		return userService.editUser(user);
	}

	@DeleteMapping("/deleteUser/{id}")
	public void deletUserById(@PathVariable("id") Integer id) {
		userService.deleteUserById(id);
		
	}

}
