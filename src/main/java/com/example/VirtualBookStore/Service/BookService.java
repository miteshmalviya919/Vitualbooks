package com.example.VirtualBookStore.Service;

import com.example.VirtualBookStore.DTO.BookDTO;
import com.example.VirtualBookStore.Entity.Book;
import com.example.VirtualBookStore.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

//    Book book = new Book();

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDTO addBook(BookDTO bookDTO) {
        // Convert DTO to Entity
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());

        // Save entity
        Book savedBook = bookRepository.save(book);

        // Convert back to DTO
        return new BookDTO(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.getPrice());
    }

    public BookDTO getBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(books -> new BookDTO(books.getId(), books.getTitle(), books.getAuthor(), books.getPrice()))
                .collect(Collectors.toList());
    }
}