package com.juno.storyvault.book;

import com.juno.storyvault.book.dto.CreateBookRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found: " + id));
    }

    public List<Book> findBookByTitle(String title){
        return bookRepository.findBookByTitleContainingIgnoreCase(title);
    }

    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findBookByAuthorContainingIgnoreCase(author);
    }

    //public List<Book> findBookByGenre(){}

    public Book createBook(CreateBookRequest request) {
        Book book = new Book(request.title(), request.author());

        return bookRepository.save(book);
    }


}
