package com.mdc.database.jpa;

import com.mdc.database.models.Book;
import com.mdc.database.models.User;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
