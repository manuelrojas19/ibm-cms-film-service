package com.ibm.academy.cms.filmservice.service.impl;

import com.ibm.academy.cms.filmservice.entity.Person;
import com.ibm.academy.cms.filmservice.repository.PersonRepository;
import com.ibm.academy.cms.filmservice.service.PersonService;
import org.bson.types.ObjectId;

public abstract class PersonServiceImpl extends GenericServiceImpl<Person, PersonRepository>
        implements PersonService  {

    public PersonServiceImpl(PersonRepository repository) {
        super(repository);
    }

    @Override
    public abstract Person update(ObjectId id, Person entity);

}
