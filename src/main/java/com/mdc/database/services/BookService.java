package com.mdc.database.services;

import com.mdc.database.dto.BookDto;
import com.mdc.database.models.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public Book mapFromDto(BookDto bookDto) {

        Book book = new Book();

        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        book.setName(bookDto.getName());
        book.setRequester(bookDto.getRequester());

        return book;
    }

}
