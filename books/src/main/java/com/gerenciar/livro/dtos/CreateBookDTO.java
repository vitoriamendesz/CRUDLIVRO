package com.gerenciar.livro.dtos;

import com.gerenciar.livro.enums.BookStatus;

public class CreateBookDTO {
    private String title;
    private String author;
    private Double price;
    private BookStatus status;

    public CreateBookDTO() {}

    public CreateBookDTO(String title, String author, Double price, BookStatus status) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.status = status;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}

