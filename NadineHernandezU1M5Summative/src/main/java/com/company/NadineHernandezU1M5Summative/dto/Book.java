package com.company.NadineHernandezU1M5Summative.dto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Book {
    //properties with validations matching schema
    private int book_id;
    @NotEmpty(message = "isbn cannot be empty")
    @Size(max = 50, message = "Cannot be more than 15 characters")
    private String isbn;
    @PastOrPresent(message = "Cannot be a future date")
    private LocalDate publish_date;
    @NotNull
    private int author_id;
    @NotEmpty(message = "title cannot be empty")
    @Size(max = 70, message = "Cannot be more than 70 characters")
    private String title;
    @NotNull
    private int publisher_id;
    @NotNull
    private BigDecimal price;

    //getters and setters
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(LocalDate publish_date) {
        this.publish_date = publish_date;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id == book.book_id &&
                author_id == book.author_id &&
                publisher_id == book.publisher_id &&
                isbn.equals(book.isbn) &&
                publish_date.equals(book.publish_date) &&
                title.equals(book.title) &&
                price.equals(book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id, isbn, publish_date, author_id, title, publisher_id, price);
    }
}
