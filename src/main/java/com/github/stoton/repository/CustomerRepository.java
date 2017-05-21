package com.github.stoton.repository;


import com.github.stoton.domain.Customer;

import java.util.List;

public interface CustomerRepository<T> {
    List<T> getAll();
    void save(T object);
    void update(T object);
    void delete(long id);
    boolean isExist(T object);
    Customer find(long id);
}
