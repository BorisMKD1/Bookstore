package com.bookstore.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bookstore.bookstore.entities.Author;
import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.repositories.AuthorRepository;


@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;

	public Author getAuthorById(Integer id) {
		return authorRepository.findById(id).get();
	}
	
	public List<Author> getAuthorByName(String name) {
		return authorRepository.findByName(name);
	}
	
	public List<Author> getAuthorByLastName(String lastName) {
		return authorRepository.findByLastName(lastName);
	}

	public Author addAuthor(Author author) {
		return authorRepository.save(author);
	}

	public Author editAuthor(Author author) {
		return authorRepository.save(author);
	}

	public void deleteAuthorById(Integer id) {
		authorRepository.deleteById(id);
	}

	public Author getAuthorByNameAndLastName(String name, String lastName) {
		return authorRepository.findByNameAndLastName(name, lastName);
	}

	public List<Author> findAll() {
		return authorRepository.findAll();
	}

}
