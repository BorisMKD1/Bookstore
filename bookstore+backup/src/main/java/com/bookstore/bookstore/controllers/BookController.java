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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.services.BookService;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
	@Autowired
	BookService bookService;

	@GetMapping("/byTitle/{title}")
	public List<Book> getBookByTitle(@PathVariable("title") String title) {
		return bookService.getBookByTitle(title);
	}

	@GetMapping("/byId/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		return bookService.getBookById(id);
	}

	
	@GetMapping("/byGenre/{genre}")
	public List<Book> getBookByGenre(@PathVariable("genre") String genre) {
		return bookService.getBookByGenre(genre);
	}

	@GetMapping("/byAuthor/{author}")
	public List<Book> getBookByAuthor(@PathVariable("author") String author) {
		return bookService.getBookByAuthor(author);
	}

	@PostMapping("/addBook/{authorId}")
	public Book addBook(@PathVariable("authorId") Integer authorId, @RequestBody Book book) {
		return bookService.addBook(book, authorId);
	}
	
	@PutMapping("/editBook")
	public Book editBook(@RequestBody Book book) {
		return bookService.editBook(book);
	}
	
	@PutMapping("/updateQuantity/{id}")
	public Book updateQuantity(@PathVariable ("id") Integer id, @RequestParam("quantity") Integer quantity) {
		return bookService.updateQuantity(id, quantity);
	}
	
	@PutMapping("/buyBook/{id}/{quantity}")
	public Book buyBook(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity){
		return bookService.buyBook(id, quantity);
	}
	
	@GetMapping("/books")
	List<Book> getAllBooks(){
		return bookService.findAll();//?
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public void deleteBookById(@PathVariable("id") Integer id) {
		bookService.deleteBookById(id);
	}
	
	@GetMapping("/searchBook")
	public List<Book> getBookBySearch(@RequestParam("search") String search) {
		return bookService.getBookBySearch(search);
	}
	}