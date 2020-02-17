package com.mdc.database.models;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class BookAudit {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    @Column(name = "ISBN_NUMBER")
    private String isbn;

    private String operationType;

    private String requester;

    private Long timeStamp;
}
