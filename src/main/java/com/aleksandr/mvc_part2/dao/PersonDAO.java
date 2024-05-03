package com.aleksandr.mvc_part2.dao;

import com.aleksandr.mvc_part2.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int person_id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",
                        new Object[]{person_id},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public Optional<Person> show(String fullName) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE full_name=?", new Object[]{fullName},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET full_name=?, year_of_birth=? WHERE id=?",
                updatedPerson.getFullName(), updatedPerson.getYearOfBirth(), id);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(full_name,year_of_birth) VALUES(?,?)",
                person.getFullName(), person.getYearOfBirth());
        System.out.println(person.getPersonId());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person where id=?", id);
    }

    public void testMultipleUpdate() {
        List<Person> people = create1000people();

        long start = System.currentTimeMillis();

        for (Person person : people) {
            jdbcTemplate.update("INSERT INTO Person(full_name,year_of_birth) VALUES(?,?)",
                    person.getFullName(), person.getYearOfBirth());
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    public void withBatchUpdate() {
        List<Person> people = create1000people();
        long start = System.currentTimeMillis();

        jdbcTemplate.batchUpdate("INSERT INTO Person(full_name,year_of_birth) VALUES(?,?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, people.get(i).getFullName());
                        ps.setInt(2, people.get(i).getYearOfBirth());
                    }

                    @Override
                    public int getBatchSize() {
                        return people.size();
                    }
                });

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

    private List<Person> create1000people() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            people.add(new Person("bob" + i, 1940));
        }

        return people;
    }
}
