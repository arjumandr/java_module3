package com.book.aop.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.book.aop.dao.Book;
import com.book.aop.dto.BookDto;
import com.book.aop.mapper.BookMapper;
import com.book.aop.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	private final BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	@PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
	public Book addBook(BookDto dto) { 
		Book book = BookMapper.toEntity(dto);
		bookRepository.save(book);
		return book;
	}
	@Override
	@PreAuthorize("hasAnyRole('TEACHER')")
    public Book updateBook(Integer id, BookDto dto) { 
    	Book book = BookMapper.toEntity(dto);
    	bookRepository.deleteById(id);
    	bookRepository.save(book);
    	return book;
    }
	@Override
	@PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
    public Book getBook(Integer id) { 
    	return bookRepository.findById(id);
    }
	@Override
	@PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
    public List<Book> getAllBooks() {
    	return bookRepository.findAll();
    }
	@Override
	@PreAuthorize("hasAnyRole('TEACHER')")
    public void deleteBook(Integer id) { 
    	bookRepository.deleteById(id);
    }
	@Override
	@PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
    public List<Book> getByAuthor(String author) {
    	return bookRepository.findAll().stream()
    						 .filter(book -> book.getAuthor()!= null && 
    						 book.getAuthor().toLowerCase().contains(author.toLowerCase())).toList();
    }
}
