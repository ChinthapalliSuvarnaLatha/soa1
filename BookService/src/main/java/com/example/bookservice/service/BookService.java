package com.example.bookservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookservice.entity.Book;
import com.example.bookservice.exception.BookNotFoundException;
import com.example.bookservice.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Add a new book
    public Book addBook(Book book) {

        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new IllegalArgumentException(
                "A book with this ISBN already exists"
            );
        }

        return bookRepository.save(book);
    }

    // View all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // View one book by ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                    new BookNotFoundException(
                        "Book not found with ID: " + id
                    )
                );
    }

    // Update an existing book
    public Book updateBook(Long id, Book updatedBook) {

        Book existingBook = getBookById(id);

        if (!existingBook.getIsbn().equals(updatedBook.getIsbn())
                && bookRepository.existsByIsbn(updatedBook.getIsbn())) {
            throw new IllegalArgumentException(
                "A book with this ISBN already exists"
            );
        }

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setIsbn(updatedBook.getIsbn());

        return bookRepository.save(existingBook);
    }

    // Delete a book
    public void deleteBook(Long id) {

        Book existingBook = getBookById(id);

        bookRepository.delete(existingBook);
    }
}
