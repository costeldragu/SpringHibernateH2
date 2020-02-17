package com.mdc.database.audit;

import com.mdc.database.jpa.BookAuditRepository;
import com.mdc.database.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Component
public class BookAuditListener {

    private final Logger logger = LoggerFactory.getLogger(BookAuditListener.class);

    @Autowired
    private static BookAuditRepository bookAuditRepository;

    
    @PrePersist
    public void onPrePersist(Book book) {
        logger.debug("PrePersist");

    }

    @PreUpdate
    public void onPreUpdate(Book book) {
        logger.debug("PreUpdate");
    }

    @PreRemove
    public void onPreRemove(Book book) {
        logger.debug("PreRemove");
    }
}
