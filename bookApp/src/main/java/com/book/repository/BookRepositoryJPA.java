package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.dto.Book;

@Repository
public interface  BookRepositoryJPA extends JpaRepository<Book, Integer>{
	Book findById(int id);
	List<Book> findByAuthor(String author);
	List<Book> findByPriceLessThan(Double price);
	boolean existsByIsbn(String isbn);
	void deleteByTitle(String title);
	List<Book> findByCategory(String category);
	@Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
	List<Book> searchByTitle(@Param("keyword") String keyword);

	@Query("SELECT b FROM Book b ORDER BY b.price DESC")
	List<Book> sortByPriceDesc();
	@Query(
	  value = "SELECT * FROM books WHERE price BETWEEN ?1 AND ?2",
	  nativeQuery = true
	)
	List<Book> findByPriceRange(double min, double max);
}
