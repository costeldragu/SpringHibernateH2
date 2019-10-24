package com.mdc.database.jpa;

import com.mdc.database.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
