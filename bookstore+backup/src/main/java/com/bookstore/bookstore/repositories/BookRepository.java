package com.bookstore.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookstore.bookstore.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findByTitle(String title);
	
	List<Book> findByGenre(String genre);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByPrice(Integer price);
	
	@Query("select b from Book b "
			+ "join b.author a "
			+ "where b.title like %:search% "
			+ "or a.name like %:search% "
			+ "or a.lastName like %:search% ")
	List<Book> findBookBySearch(String search);


}
