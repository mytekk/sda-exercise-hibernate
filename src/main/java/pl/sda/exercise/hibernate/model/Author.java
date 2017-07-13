package pl.sda.exercise.hibernate.model;

import java.util.Set;

/**
 * Created by RENT on 2017-07-13.
 */
public class Author {

    //klaswa - encja dla tabeli author z bazy danych

    private Integer authorId;
    private String firstName;
    private String lastName;
    private Set<Book> books;    //referencja do ksiazek tego autora

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
