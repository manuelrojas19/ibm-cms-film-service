package com.ibm.academy.cms.filmservice.service.impl;

import com.ibm.academy.cms.filmservice.exception.NotFoundException;
import com.ibm.academy.cms.filmservice.service.GenericService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@AllArgsConstructor
public abstract class GenericServiceImpl<E, R extends MongoRepository<E, ObjectId>> implements GenericService<E> {

    public static final String NOT_FOUND_ERROR_MSG = "Resource was not found";

    protected final R repository;

    @Override
    public E findById(ObjectId id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_ERROR_MSG));
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E create(E entity) {
        return repository.save(entity);
    }

    @Override
    public abstract E update(ObjectId id, E entity);

    @Override
    public void delete(ObjectId id) {
        repository.deleteById(id);
    }
}
