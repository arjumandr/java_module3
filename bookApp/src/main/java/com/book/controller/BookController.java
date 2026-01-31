package com.book.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.Book;
import com.book.dto.BookDto;
import com.book.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
	private final BookService bookService;

	public BookController(BookService bookService) {
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
}
