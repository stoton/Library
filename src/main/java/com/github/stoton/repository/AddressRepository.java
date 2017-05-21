package com.github.stoton.repository;

import java.util.List;

public interface AddressRepository<T>  {
    List<T> getAll();
    void save(T object);
    void update(T object);
    void delete(long id);
}
