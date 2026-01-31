package com.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookDto {
	@NotBlank(message = "Title must not be empty.")
    private String title;
	@NotBlank(message = "Author's name must not be empty.")
    private String author;
	@Positive(message = "Price of book must be valid positiv number.")
    private double price;
}
