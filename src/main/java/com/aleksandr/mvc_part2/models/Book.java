package com.aleksandr.mvc_part2.models;

import javax.validation.constraints.*;
import java.util.Calendar;
import java.util.Objects;

public class Book {
    private int id;
    @NotEmpty(message = "field title should not be empty")
    @Size(max = 100)
    private String title;
    @NotEmpty(message = "field author should not be empty")
    @Pattern(regexp = "[A-Z][- A-Za-z]+", message = "The author must begin with a capital letter and can only contain letters, hyphens, and spaces")
    private String author;
    @NotEmpty(message = "field age of release should not be empty")
    @Min(value = -2000)
    @Max(value = 2024)
    private String ageOfRelease;

    public Book(String title, String author, String ageOfRelease) {
        this.title = title;
        this.author = author;
        this.ageOfRelease = ageOfRelease;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public @NotEmpty(message = "field age of release should not be empty") @Min(value = -2000) @Max(value = 2024) String getAgeOfRelease() {
        return ageOfRelease;
    }

    public void setAgeOfRelease(@NotEmpty(message = "field age of release should not be empty") @Min(value = -2000) @Max(value = 2024) String ageOfRelease) {
        this.ageOfRelease = ageOfRelease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId() == book.getId() && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getAgeOfRelease(), book.getAgeOfRelease());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getAuthor(), getAgeOfRelease());
    }
}
