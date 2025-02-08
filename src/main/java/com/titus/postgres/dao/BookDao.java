package com.titus.postgres.dao;

import java.util.List;
import java.util.Optional;

import com.titus.postgres.domain.Book;

public interface BookDao {

    public void create(Book book);

    Optional<Book> findOne(String isbn);

    List<Book> find();

    void update(Book book);

};
