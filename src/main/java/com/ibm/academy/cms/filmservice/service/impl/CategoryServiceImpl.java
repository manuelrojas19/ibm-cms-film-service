package com.ibm.academy.cms.filmservice.service.impl;

import com.ibm.academy.cms.filmservice.entity.Category;
import com.ibm.academy.cms.filmservice.repository.CategoryRepository;
import com.ibm.academy.cms.filmservice.service.CategoryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, CategoryRepository> implements CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Category update(ObjectId id, Category category) {
        Category categoryToUpdate = this.findById(id);
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setDescription(category.getDescription());
        return repository.save(categoryToUpdate);
    }
}
