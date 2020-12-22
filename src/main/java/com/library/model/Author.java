package com.library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long author_id;

    @Column(name = "author_firstname")
    private String author_firstname;

    @Column(name = "author_lastname")
    private String author_lastname;

    @OneToMany(mappedBy ="author", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Book> book;

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    public Author(long author_id, String author_firstname, String author_lastname) {
        this.author_id = author_id;
        this.author_firstname = author_firstname;
        this.author_lastname = author_lastname;
    }

    public Author() {
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_firstname() {
        return author_firstname;
    }

    public void setAuthor_firstname(String author_firstname) {
        this.author_firstname = author_firstname;
    }

    public String getAuthor_lastname() {
        return author_lastname;
    }

    public void setAuthor_lastname(String author_lastname) {
        this.author_lastname = author_lastname;
    }
}
