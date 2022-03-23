package com.ibm.academy.cms.filmservice.service.impl;

import com.ibm.academy.cms.filmservice.entity.Actor;
import com.ibm.academy.cms.filmservice.entity.Person;
import com.ibm.academy.cms.filmservice.repository.PersonRepository;
import com.ibm.academy.cms.filmservice.service.ActorService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActorServiceImpl extends PersonServiceImpl implements ActorService {

    @Autowired
    public ActorServiceImpl(@Qualifier("actorRepository") PersonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Person update(ObjectId id, Person actor) {
        Actor actorToUpdate = (Actor) this.findById(id);
        actorToUpdate.setName(actor.getName());
        actorToUpdate.setDescription(actor.getDescription());
        actorToUpdate.setBornDate(actor.getBornDate());
        actorToUpdate.setBornPlace(actor.getBornPlace());
        return repository.save(actorToUpdate);
    }
}
