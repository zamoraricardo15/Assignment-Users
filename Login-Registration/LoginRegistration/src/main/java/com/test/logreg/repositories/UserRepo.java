package com.test.logreg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.logreg.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByEmail(String email);
}