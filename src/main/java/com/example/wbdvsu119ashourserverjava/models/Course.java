package com.example.wbdvsu119ashourserverjava.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToOne
    @JsonIgnore
    private Faculty author;

    @Transient
    public String getAuthorName() {
        return author != null ? author.getFirstName() + " " + author.getLastName() : "";
    }

    public Faculty getAuthor() {
        return author;
    }

    public void setAuthor(Faculty author) {
        this.author = author;
    }

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
}