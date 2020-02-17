package com.mdc.database.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@Audited
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    @Column(name = "ISBN_NUMBER")
    private String isbn;

    private String requester;


    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;


}
