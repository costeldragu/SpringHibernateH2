package com.mdc.database.jpa;

import com.mdc.database.models.BookAudit;
import org.springframework.data.repository.CrudRepository;

public interface BookAuditRepository extends CrudRepository<BookAudit, Long> {
}
