package com.ibm.academy.cms.filmservice.service.impl;

import com.ibm.academy.cms.filmservice.entity.Director;
import com.ibm.academy.cms.filmservice.entity.Person;
import com.ibm.academy.cms.filmservice.repository.PersonRepository;
import com.ibm.academy.cms.filmservice.service.DirectorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl extends PersonServiceImpl implements DirectorService {

    @Autowired
    public DirectorServiceImpl(@Qualifier("directorRepository") PersonRepository repository) {
        super(repository);
    }

    @Override
    public Person update(ObjectId id, Person director) {
        Director directorToUpdate = (Director) this.findById(id);
        directorToUpdate.setName(director.getName());
        directorToUpdate.setDescription(director.getDescription());
        directorToUpdate.setBornDate(director.getBornDate());
        directorToUpdate.setBornPlace(director.getBornPlace());
        return repository.save(directorToUpdate);
    }
}
