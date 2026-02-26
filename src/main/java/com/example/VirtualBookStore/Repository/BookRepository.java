package com.example.VirtualBookStore.Repository;

import com.example.VirtualBookStore.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);
    List<Book> findByAuthor(String author);


}
