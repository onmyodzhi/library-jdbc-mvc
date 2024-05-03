package com.aleksandr.mvc_part2.dao;

import com.aleksandr.mvc_part2.models.Book;
import com.aleksandr.mvc_part2.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDao {
    private final JdbcTemplate jdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        String sql = "select * from book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int book_id) {
        String sql = "select * from book where book_id=?";
        return jdbcTemplate.query(sql, new Object[]{book_id},
                        new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Book updatedBook) {
        String sql = "update book set title=?, author=?, year_of_release=? where book_id=?";
        jdbcTemplate.update(sql,
                updatedBook.getTitle(),
                updatedBook.getAuthor(),
                updatedBook.getAgeOfRelease(),
                id);
    }

    public void save(Book book) {
        String sql = "insert into book(title, author, year_of_release) values(?,?,?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getAgeOfRelease());
    }

    public void delete(int book_id) {
        String sql = "delete from book where book_id=?";
        jdbcTemplate.update(sql, book_id);
    }

    public Optional<Person> getBookOwner(int book_id) {
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON " +
                        "Book.person_id = Person.person_id WHERE book_id = ?",
                new Object[]{book_id},
                new BeanPropertyRowMapper(Person.class)).stream().findAny();
    }

    public void release(int book_id) {
        jdbcTemplate.update("UPDATE Book SET person_id=null where book_id=?", book_id);
    }

    public void assign(int book_id, Person selectedPerson) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE book_id=?", selectedPerson.getPersonId(), book_id);
    }
}
