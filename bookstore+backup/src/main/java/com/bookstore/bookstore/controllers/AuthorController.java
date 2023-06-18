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

import com.bookstore.bookstore.entities.Author;
import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.services.AuthorService;

@RestController
@RequestMapping("/author") //url
@CrossOrigin
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/byName/{name}")
	public List<Author> getAuthorByName(@PathVariable("name") String name) {
		return authorService.getAuthorByName(name);
	}

	@GetMapping("/byNameAndLastName/{name}/{lastName}")
	public Author getAuthorByLastName(@PathVariable("name") String name, @PathVariable("lastName") String lastName) {
		return authorService.getAuthorByNameAndLastName(name, lastName);
	}
	
	@GetMapping("/byId/{id}")
	public Author getAuthorById(@PathVariable("id") Integer id) {
		return authorService.getAuthorById(id);
	}
	
	@PostMapping("/addAuthor")
	public Author addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);
	}
	
	@PutMapping("/editAuthor")
	public Author editAuthor(@RequestBody Author author) {
		return authorService.editAuthor(author);
	}
	
	@DeleteMapping("/deleteAuthor/{id}")
	public void deleteAuthorById(@PathVariable("id") Integer id) {
		authorService.deleteAuthorById(id);
	}
	
	@GetMapping("/authors")
	List<Author> getAllAuthors(){
		return authorService.findAll();//a ilo?
	}
}
