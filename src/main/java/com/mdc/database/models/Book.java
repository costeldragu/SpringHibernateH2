package com.mdc.database.models;

import com.mdc.database.audit.BookAuditListener;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
@EntityListeners(BookAuditListener.class)
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    @Column(name = "ISBN_NUMBER")
    private String isbn;

    private String requester;




}
