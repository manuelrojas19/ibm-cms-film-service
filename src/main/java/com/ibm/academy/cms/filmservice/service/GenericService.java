package com.ibm.academy.cms.filmservice.service;

import org.bson.types.ObjectId;

import java.util.List;

public interface GenericService<E> {
    E findById(ObjectId id);

    List<E> findAll();

    E create(E entity);

    E update(ObjectId id, E entity);

    void delete(ObjectId id);
}
