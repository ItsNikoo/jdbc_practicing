package com.example;

public class Book {
    private int id;
    private String author;
    private String title;

    Book(){}
    Book(int id, String author, String title){
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
