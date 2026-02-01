package com.book.jdbc.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.dto.Book;
import com.book.rowmapper.BookRowMapper;

@Repository
public class BookJdbcDao {
	private final JdbcTemplate jdbc;
	private final BookRowMapper bookRowMapper;

	public BookJdbcDao(JdbcTemplate jdbc, BookRowMapper bookRowMapper) {
		this.jdbc = jdbc;
		this.bookRowMapper = bookRowMapper;
	}
	public int save(Book b) { 
		String sql = "INSERT INTO books_jdbc(title, author, price, isbn) VALUES (?, ?, ?, ?)";
		return jdbc.update(sql, b.getTitle(), b.getAuthor(), b.getPrice(), b.getIsbn());
	}

    public Book findById(int id) { 
    	String sql = "select * fom books_jdbc where id=?";
    	return jdbc.queryForObject(sql, bookRowMapper, id);
    }

    public List<Book> findAll() { 
    	String sql = "select * from books_jdbc";
    	return jdbc.query(sql,  bookRowMapper);
    }

    public int update(Integer id, Book b) { 
    	String sql = "UPDATE books_jdbc SET title=?, author=?, price=?, isbn=? WHERE id=?";
        return jdbc.update(
                sql,
                b.getTitle(),
                b.getAuthor(),
                b.getPrice(),
                b.getIsbn(),
                b.getId()
        );
    }

    public int delete(int id) { 
    	String sql = "DELETE FROM books_jdbc WHERE id=?";
        return jdbc.update(sql, id);
    }
	
}
