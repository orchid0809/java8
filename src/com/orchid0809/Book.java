package com.orchid0809;

import java.time.LocalDate;

/**
 * Created by orchid0809 on 2018/3/4.
 */
public class Book {

    private int id;

    private String name;

    private LocalDate publicDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(LocalDate publicDate) {
        this.publicDate = publicDate;
    }

    public Book(int id, String name, LocalDate publicDate) {
        this.id = id;
        this.name = name;
        this.publicDate = publicDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicDate=" + publicDate +
                '}';
    }
}
