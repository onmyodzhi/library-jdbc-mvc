package com.aleksandr.mvc_part2.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Book {
    private int bookId;
    @NotEmpty(message = "field title should not be empty")
    @Size(max = 100)
    private String title;
    @NotEmpty(message = "field author should not be empty")
    @Pattern(regexp = "[A-Z][- A-Za-z]+", message = "The author must begin with a capital letter and can only contain letters, hyphens, and spaces")
    private String author;
    @NotNull(message = "Field age of release should not be empty")
    @Min(value = -2000, message = "must be greater than or equal to -2000")
    @Max(value = 2024, message = "must be less than or equal to 2024")
    private int ageOfRelease;

    public Book(String title, String author, int ageOfRelease) {
        this.title = title;
        this.author = author;
        this.ageOfRelease = ageOfRelease;
    }

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public @NotEmpty(message = "field title should not be empty") @Size(max = 100) String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "field title should not be empty") @Size(max = 100) String title) {
        this.title = title;
    }

    public @NotEmpty(message = "field author should not be empty") @Pattern(regexp = "[A-Z][- A-Za-z]+", message = "The author must begin with a capital letter and can only contain letters, hyphens, and spaces") String getAuthor() {
        return author;
    }

    public void setAuthor(@NotEmpty(message = "field author should not be empty") @Pattern(regexp = "[A-Z][- A-Za-z]+", message = "The author must begin with a capital letter and can only contain letters, hyphens, and spaces") String author) {
        this.author = author;
    }

    public @NotNull(message = "field age of release should not be empty") @Min(value = -2000) @Max(value = 2024) int getAgeOfRelease() {
        return ageOfRelease;
    }

    public void setAgeOfRelease(@NotNull(message = "field age of release should not be empty") @Min(value = -2000) @Max(value = 2024) int ageOfRelease) {
        this.ageOfRelease = ageOfRelease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getAgeOfRelease(), book.getAgeOfRelease());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getTitle(), getAuthor(), getAgeOfRelease());
    }

    @Override
    public String toString() {
        return
                "book id = " + bookId +
                ", title = '" + title + '\'' +
                ", author = '" + author + '\'' +
                ", age of release = '" + ageOfRelease + '\'';
    }
}
