package com.ibm.academy.cms.filmservice.service.impl;

import com.ibm.academy.cms.filmservice.exception.NotFoundException;
import com.ibm.academy.cms.filmservice.service.GenericService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public abstract class GenericServiceImpl<E, R extends MongoRepository<E, ObjectId>> implements GenericService<E> {

    public static final String NOT_FOUND_ERROR_MSG = "Resource was not found";

    protected final R repository;

    @Override
    @Transactional(readOnly = true)
    public E findById(ObjectId id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_ERROR_MSG));
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public E create(E entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public abstract E update(ObjectId id, E entity);

    @Override
    @Transactional
    public void delete(ObjectId id) {
        repository.deleteById(id);
    }
}
