package com.ibm.academy.cms.filmservice.repository;

import com.ibm.academy.cms.filmservice.entity.Category;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface CategoryRepository extends Neo4jRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
