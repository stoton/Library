package com.github.stoton.repository;

import com.github.stoton.domain.Book;

import java.util.List;

public interface BookRepository<T> {
    Book find(long id);
    List<T> getAll();
    void save(T object);
    void update(T object);
    void delete(long id);
    boolean isExist(T object);
}
