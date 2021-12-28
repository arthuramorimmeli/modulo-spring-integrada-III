package com.wave4.restaurante.services.interfaces;

import java.util.List;

public interface CrudInterface<T, D> {

    T create(D d);
    T edit(T t, D d);
    void remove(T t);
    void remove(Long i);
    List<T> findAll();
    T findById(Long id);

}
