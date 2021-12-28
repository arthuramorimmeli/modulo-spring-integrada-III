package com.wave4.restaurante.dtos.interfaces;

public interface ConverterInterface<T, D> {

    T convert();
    D convert(T t);
}
