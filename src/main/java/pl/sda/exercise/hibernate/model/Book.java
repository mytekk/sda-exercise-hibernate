package pl.sda.exercise.hibernate.model;

import java.util.Set;

public class Book {


    private Integer id;
    private String title;
    private Author author; //referencja do autora ksiazki
    private Set<Category> categories; //relacja wiele-do-wielu do categorii
                                    //w bazie jest do tego tabelka posredniczaca

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
