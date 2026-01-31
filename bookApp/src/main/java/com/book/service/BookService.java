package com.book.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.book.dto.Book;
import com.book.dto.BookDto;
import com.book.repository.BookRepository;
import com.book.util.BookMapper;

@Service
public class BookService {

//    private final BookController bookController;
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public Book addBook(BookDto dto) { 
		Book book = BookMapper.toEntity(dto);
		bookRepository.save(book);
		return book;
	}
    public Book updateBook(Integer id, BookDto dto) { 
    	Book book = BookMapper.toEntity(dto);
    	bookRepository.deleteById(id);
    	bookRepository.save(book);
    	return book;
    }
    public Book getBook(Integer id) { 
    	return bookRepository.findById(id);
    }
    public List<Book> getAllBooks() {
    	return bookRepository.findAll();
    }
    public void deleteBook(Integer id) { 
    	bookRepository.deleteById(id);
    }
    public List<Book> getByAuthor(String author) {
    	return bookRepository.findAll().stream()
    						 .filter(book -> book.getAuthor()!= null && 
    						 book.getAuthor().toLowerCase().contains(author.toLowerCase())).toList();
    }
}
