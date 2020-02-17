package com.mdc.database.rest;

import com.mdc.database.dto.BookDto;
import com.mdc.database.jpa.BookRepository;
import com.mdc.database.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewUser(@RequestBody BookDto bookDto) {
        bookRepository.save(bookService.mapFromDto(bookDto));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
