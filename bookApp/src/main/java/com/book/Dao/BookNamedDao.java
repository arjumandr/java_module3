package com.book.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.dto.Book;
import com.book.rowmapper.BookRowMapper;

@Repository
public class BookNamedDao {
	private final NamedParameterJdbcTemplate named;
	private final BookRowMapper bookRowMapper;

    public BookNamedDao(NamedParameterJdbcTemplate named) {
        this.named = named;
		this.bookRowMapper = new BookRowMapper();
    }

    public List<Book> findByAuthor(String author) { 
    	String sql = "select * from books_jdbc where author = :author";
    	Map<String, Object> params = new HashMap<>();
    	params.put("author", author);
    	return named.query(sql, params, bookRowMapper);    	
    }

    public List<Book> findByPriceRange(double min, double max) { 
    	String sql = "select * from books_jdbc where price between :min and :max";
    	Map<String, Object> params = new HashMap<>();
        params.put("min", min);
        params.put("max", max);

        return named.query(sql, params, bookRowMapper);
    }
}
/*
SQL Examples:
SELECT * FROM books_jdbc WHERE author = :author

SELECT * FROM books_jdbc WHERE price BETWEEN :min AND :max
Q5. Integrate JDBC DAO Into REST API
*/

