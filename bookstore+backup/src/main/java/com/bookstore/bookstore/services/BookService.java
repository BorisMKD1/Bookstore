package com.bookstore.bookstore.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entities.Author;
import com.bookstore.bookstore.entities.Book;
import com.bookstore.bookstore.exception.BookstoreException;
import com.bookstore.bookstore.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	AuthorService authorService;
	@Autowired
	private BookRepository bookRepository;

	public Book getBookById(Integer id) {
		return bookRepository.findById(id).get();
	}

	public List<Book> getBookByTitle(String title) {
		return bookRepository.findByTitle(title);
	}

	public List<Book> getBookByGenre(String genre) {
		return bookRepository.findByGenre(genre);
	}

	public List<Book> getBookByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Transactional
	public Book addBook(Book book, Integer authorId) {
		Author author = authorService.getAuthorById(authorId);
		book.setAuthor(author);
		return bookRepository.save(book);
	}

	@Transactional
	public Book editBook(Book book) {
		return bookRepository.save(book); // mi pobara da stavam "save" vo book repository
	}

	public void deleteBookById(Integer id) {
		bookRepository.deleteById(id);
	}

	@Transactional
	public Book buyBook(Integer id, Integer quantity) {
		Book book = getBookById(id);
		if (book.getStock() >= quantity) {
			book.setStock(book.getStock() - quantity);
			return bookRepository.save(book);// ne mora save da stoi, se grizhi hibernate
		} else
			throw new BookstoreException("NOT ENOUGH BOOKS ON STOCK");

	}

	@Transactional
	public Book updateQuantity(Integer id, Integer quantity) {
		Book book = getBookById(id);
		book.setStock(quantity + book.getStock());
		return bookRepository.save(book);
	}

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public List<Book> getBookBySearch(String search) {
		return bookRepository.findBookBySearch(search);
	}
	
}
