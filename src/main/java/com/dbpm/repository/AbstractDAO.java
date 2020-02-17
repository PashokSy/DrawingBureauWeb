package com.dbpm.repository;

import java.util.List;

public interface AbstractDAO<T> {

    T create(T t);
    T findById(Long id);
    T update(T t);
    boolean delete(Long id);
    List<T> getAll();
}
