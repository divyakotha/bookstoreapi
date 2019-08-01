package com.services.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.services.store.model.Book;
 
@Repository
public interface BooksRepository
        extends JpaRepository<Book, Long> {
 
	@Query("SELECT b FROM Book b WHERE b.bookDescription LIKE %?1%")
	public List<Book> findByBooksLike(String bookName);
}
