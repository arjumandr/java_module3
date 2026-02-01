package com.book.aop.service;

import java.util.List;

import com.book.aop.dao.Book;
import com.book.aop.dto.BookDto;

public interface BookService {

    Book addBook(BookDto dto);

    Book getBook(Integer id);

    Book updateBook(Integer id, BookDto dto);

    void deleteBook(Integer id);

    List<Book> getAllBooks();

	List<Book> getByAuthor(String author);
}
