package com.ibm.academy.cms.filmservice.service.impl;

import com.ibm.academy.cms.filmservice.entity.Film;
import com.ibm.academy.cms.filmservice.repository.FilmRepository;
import com.ibm.academy.cms.filmservice.service.FilmService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl extends GenericServiceImpl<Film, FilmRepository> implements FilmService {

    @Autowired
    public FilmServiceImpl(FilmRepository repository) {
        super(repository);
    }

    @Override
    public Film update(ObjectId id, Film film) {
        Film filmToUpdate = this.findById(id);
        filmToUpdate.setTitle(film.getTitle());
        filmToUpdate.setDescription(film.getDescription());
        filmToUpdate.setDate(film.getDate());
        return repository.save(filmToUpdate);
    }
}
