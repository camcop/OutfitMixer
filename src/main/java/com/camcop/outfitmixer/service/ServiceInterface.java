package com.camcop.outfitmixer.service;

import java.util.List;

public interface ServiceInterface<T> {

    //	Create
    T add(T t);

    //	Read all
    List<T> getAll();

    //	Read one
    T getById(Long id);

}
