package com.book.controller;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.Book;
import com.book.dto.BookDto;
import com.book.service.BookServiceJPA;

import jakarta.validation.Valid;


@RestController
@Profile("jpa")
@RequestMapping("/api/books")
public class BookControllerJPA {
//	private final BookService bookService;
	private final BookServiceJPA bookService;

	public BookControllerJPA(BookServiceJPA bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
	public Book add(@RequestBody @Valid BookDto bookDto) {
		return bookService.addBook(bookDto);
	}
	
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody @Valid BookDto bookDto) {
		return bookService.updateBook(id, bookDto);
	}
	@GetMapping("/{id}")
	public Book get(@PathVariable Integer id) {
		return bookService.getBook(id);
	}
	@GetMapping()
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	@DeleteMapping("/{id}")
	public void deleteById(@RequestBody Integer id) {
		bookService.deleteBook(id);
	}
	@GetMapping("/{name}")
	public List<Book> get(@PathVariable String name) {
		return bookService.getByAuthor(name);
	}
	@GetMapping("author/{author}")
	public List<Book> getByAuthor(@PathVariable String author) {
		return bookService.findByAuthor(author);
	}
	@GetMapping("category/{category}")
	public List<Book> getByCategory(@PathVariable String category){
		return bookService.findByCategory(category);
	}
	@GetMapping("/price/less/{price}")
	public List<Book> findByPriceLessThan(@PathVariable double price){
		return bookService.findByPriceLessThan(price);
	}
	@GetMapping("/price-range")
	public List<Book> findByPriceRange(@RequestParam("min") double minprice, @RequestParam("max") double maxprice){
		return bookService.findByPriceRange(minprice, maxprice);
	}
	@GetMapping("/search/{keyword}")
	public List<Book> searchByTitle(@PathVariable String keyword){
		return bookService.searchByTitle(keyword);
	}
	
}
