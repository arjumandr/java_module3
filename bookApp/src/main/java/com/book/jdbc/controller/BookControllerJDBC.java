package com.book.jdbc.controller;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.Dao.BookNamedDao;
import com.book.dto.Book;
import com.book.jdbc.Dao.BookJdbcDao;

import jakarta.validation.Valid;

@RestController
@Profile("jdbc")
@RequestMapping("/api/jdbc/books")
public class BookControllerJDBC {
	private final BookJdbcDao bookDao;
	private final BookNamedDao bookNamedDao;
	public BookControllerJDBC(BookJdbcDao bookDao, BookNamedDao bookNamedDao) {
		this.bookDao = bookDao;
		this.bookNamedDao = bookNamedDao;
	}
	@GetMapping("/{id}")
	public Book get(@PathVariable Integer id) {
		return bookDao.findById(id);
	}
	@GetMapping()
	public List<Book> getAllBooks(){
		return bookDao.findAll();
	}	
	@PostMapping
	public int add(@RequestBody @Valid Book book) {
		return bookDao.save(book);
	}
	
	@PutMapping("/{id}")
	public int updateBook(@PathVariable Integer id, @RequestBody @Valid Book book) {
		return bookDao.update(id, book);
	}
	@GetMapping("/author/{author}")
	public List<Book> findByAuthor(@PathVariable String author){
		return bookNamedDao.findByAuthor(author);
	}
	@GetMapping("/price-range")
	public List<Book> findByPriceRange(@RequestParam("min") double minprice, @RequestParam("max") double maxprice){
		return bookNamedDao.findByPriceRange(minprice, maxprice);
	}
}
/*
GET    /api/jdbc/books
GET    /api/jdbc/books/{id}
POST   /api/jdbc/books
PUT    /api/jdbc/books/{id}
DELETE /api/jdbc/books/{id}
Named query endpoints:
GET /api/jdbc/books/author/{author}
GET /api/jdbc/books/price-range?min=100&max=500
*/
