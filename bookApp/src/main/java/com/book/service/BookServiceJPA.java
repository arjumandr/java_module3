package com.book.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dto.Book;
import com.book.dto.BookDto;
import com.book.exception.BookNotFoundException;
import com.book.repository.BookRepositoryJPA;
import com.book.util.BookMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceJPA{
	private final BookRepositoryJPA bookRepo;

	@Autowired
	public BookServiceJPA(BookRepositoryJPA bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public Book addBook(BookDto dto) { 
		Book book = BookMapper.toEntity(dto);
		bookRepo.save(book);
		return book;
	}
    public Book updateBook(Integer id, BookDto dto) { 
    	Book book = BookMapper.toEntity(dto);
    	bookRepo.deleteById(id);
    	bookRepo.save(book);
    	return book;
    }
    public Book getBook(Integer id) { 
    	return bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }
    public List<Book> getAllBooks() {
    	return bookRepo.findAll();
    }
    public void deleteBook(Integer id) { 
    	bookRepo.deleteById(id);
    }
    public List<Book> getByAuthor(String author) {
    	return bookRepo.findAll().stream()
    						 .filter(book -> book.getAuthor()!= null && 
    						 book.getAuthor().toLowerCase().contains(author.toLowerCase())).toList();
    }	
	
	public List<Book> findByAuthor(String author){
		return bookRepo.findByAuthor(author);
	}
	public List<Book> findByPriceLessThan(Double price){
		return bookRepo.findByPriceLessThan(price);
	}
	public List<Book> findByCategory(String category){
		return bookRepo.findByCategory(category);
	}
	public boolean existsByIsbn(String isbn) {
		return bookRepo.existsByIsbn(isbn);
	}
	public void deleteByTitle(String title) {
		bookRepo.deleteByTitle(title);
	}
}
