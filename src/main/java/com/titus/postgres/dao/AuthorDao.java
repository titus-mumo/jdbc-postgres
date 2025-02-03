package com.titus.postgres.dao;

import java.util.Optional;

import com.titus.postgres.domain.Author;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long id);
}
