package com.example.VirtualBookStore.Controller;

import com.example.VirtualBookStore.DTO.BookDTO;
import com.example.VirtualBookStore.Entity.Book;
import com.example.VirtualBookStore.Repository.BookRepository;
import com.example.VirtualBookStore.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public BookDTO addBook(@RequestBody BookDTO book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @GetMapping("getbooks")
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/test")
   public  String Hello(){
        return "hello world";
    }

}
