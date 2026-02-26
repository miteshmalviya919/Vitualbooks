package com.example.VirtualBookStore.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookDTO {

    private Long id;
    private String title;
    private String author;
    private String description;
    private double price;

//    public BookDTO(Long id, String title, String author, String description, double price) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.description = description;
//        this.price = price;
//    }


    public BookDTO(Long id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }





}
