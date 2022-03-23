package com.ibm.academy.cms.filmservice.service;

import com.ibm.academy.cms.filmservice.entity.Film;
import org.bson.types.ObjectId;

public interface FilmService extends GenericService<Film> {
    Film addActorToFilm(ObjectId actorId, ObjectId filmId);
}
