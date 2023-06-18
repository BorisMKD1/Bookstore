package com.bookstore.bookstore.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.bookstore.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	List<Author> findByName(String name);

	List<Author> findByLastName(String lastName);

	Author findByNameAndLastName(String name, String lastName);

}
