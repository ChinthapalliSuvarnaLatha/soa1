package com.example.library.controller;

import org.springframework.web.bind.annotation.*;

import com.example.library.model.Book;

@RestController
public class LibraryController {

    @PostMapping("/libraries/{libraryId}/books")
    public String addBook(@PathVariable int libraryId,
                          @RequestBody Book book) {

        return "Book Added Successfully\n"
                + "Library ID : " + libraryId
                + "\nBook ID : " + book.getBookId()
                + "\nTitle : " + book.getTitle()
                + "\nAuthor : " + book.getAuthor()
                + "\nQuantity : " + book.getQuantity();
    }
}
