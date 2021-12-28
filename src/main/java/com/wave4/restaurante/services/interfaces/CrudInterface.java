package com.wave4.restaurante.services.interfaces;

import java.util.List;

public interface CrudInterface<T> {

    T create(T t);
    T edit(T t);
    void remove(T t);
    void remove(Long i);
    List<T> findAll();
    T findById(Long id);

}
