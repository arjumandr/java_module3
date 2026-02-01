package com.book.aop.dao;


public class Book {
	private Integer id;
	private String isbn;
    private String title;
    private String author;
    private double price;
    private String category;
    public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Book() {}
	public Book(Integer id, String isbn, String title, String author, double price, String category) {
		this.id = id;
		this.setIsbn(isbn);
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
	}
	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public Integer setId(int id) {
		return this.id = id;
	}	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
    
}
