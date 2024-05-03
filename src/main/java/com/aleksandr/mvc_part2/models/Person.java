package com.aleksandr.mvc_part2.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Person {
    private int personId;
    @NotEmpty(message = "This field should not empty")
    @NotNull(message = "This field should not empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Pattern(regexp = "[A-Z][- A-Za-z]+", message = "Full name must begin with a capital letter and can only contain letters, hyphens, and spaces")
    private String FullName;
    @Min(value = 1900, message = "age of year should be more then 1900")
    @NotNull(message = "field year of birth should not be empty")
    private int yearOfBirth;

    public Person(String FullName, int ageOfYear) {
        this.FullName = FullName;
        this.yearOfBirth = ageOfYear;
    }

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        this.FullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getPersonId() == person.getPersonId() && getYearOfBirth() == person.getYearOfBirth() && Objects.equals(getFullName(), person.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getFullName(), getYearOfBirth());
    }

    @Override
    public String toString() {
        return
                "person id = " + personId +
                ", Full name = '" + FullName + '\'' +
                ", year of birth = " + yearOfBirth;
    }
}
