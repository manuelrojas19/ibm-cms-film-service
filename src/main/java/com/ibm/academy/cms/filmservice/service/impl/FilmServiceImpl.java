package com.ibm.academy.cms.filmservice.service.impl;

import com.ibm.academy.cms.filmservice.entity.Actor;
import com.ibm.academy.cms.filmservice.entity.Film;
import com.ibm.academy.cms.filmservice.exception.BadRequestException;
import com.ibm.academy.cms.filmservice.exception.NotFoundException;
import com.ibm.academy.cms.filmservice.repository.ActorRepository;
import com.ibm.academy.cms.filmservice.repository.FilmRepository;
import com.ibm.academy.cms.filmservice.service.FilmService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilmServiceImpl extends GenericServiceImpl<Film, FilmRepository> implements FilmService {

    public static final String ACTOR_NOT_FOUND_ERROR_MSG = "Actor was not found";
    public static final String ACTOR_CURRENTLY_ADDED_ERROR_MSG = "This actor is currently added to this film";

    private final ActorRepository actorRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository repository, ActorRepository actorRepository) {
        super(repository);
        this.actorRepository = actorRepository;
    }

    @Override
    @Transactional
    public Film update(ObjectId id, Film film) {
        Film filmToUpdate = this.findById(id);
        filmToUpdate.setTitle(film.getTitle());
        filmToUpdate.setDescription(film.getDescription());
        filmToUpdate.setDate(film.getDate());
        return repository.save(filmToUpdate);
    }

    @Override
    @Transactional
    public Film addActorToFilm(ObjectId actorId, ObjectId filmId) {
        Film film = this.findById(filmId);
        Actor actor = (Actor) actorRepository.findById(actorId)
                .orElseThrow(() -> new NotFoundException(ACTOR_NOT_FOUND_ERROR_MSG));

        if (film.getActors().contains(actor))
            throw new BadRequestException(ACTOR_CURRENTLY_ADDED_ERROR_MSG);

        actor.getFilms().add(film);
        actorRepository.save(actor);

        film.getActors().add(actor);
        return repository.save(film);
    }
}
