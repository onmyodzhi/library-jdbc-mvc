package com.aleksandr.mvc_part2.dao;

import com.aleksandr.mvc_part2.models.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Book> index() {
        String sql = "select * from book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>() {});
    }

    public Book show(int book_id) {
        String sql = "select * from book where book_id=?";
        return jdbcTemplate.query(sql, new Object[]{book_id},
                new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Book updatedBook) {
        String sql = "update person set title=?, author=?, age_of_release=? where id=?";
        jdbcTemplate.update(sql,
                updatedBook.getTitle(),
                updatedBook.getAuthor(),
                updatedBook.getAgeOfRelease(),
                id);
    }

    public void save(Book book) {
        String sql = "insert into book(title, author, age_of_release) values(?,?,?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getAgeOfRelease());
    }

    public void delete(int book_id) {
        String sql = "delete from book where book_id=?";
        jdbcTemplate.update(sql, book_id);
    }
}
