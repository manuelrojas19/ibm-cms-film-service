package com.ibm.academy.cms.filmservice.service.impl;

import com.ibm.academy.cms.filmservice.service.GenericService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@AllArgsConstructor
public class GenericServiceImpl<E, R extends MongoRepository<E, ObjectId>> implements GenericService<E> {

    protected final R repository;

    @Override
    public E findById(ObjectId id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not founded"));
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
    public E update(ObjectId id, E entity) {
        this.findById(id);
        return repository.save(entity);
    }

    @Override
    public void delete(ObjectId id) {
        repository.deleteById(id);
    }
}
