package com.ibm.academy.cms.filmservice.controller;

import com.ibm.academy.cms.filmservice.assembler.FilmAssembler;
import com.ibm.academy.cms.filmservice.dto.FilmDto;
import com.ibm.academy.cms.filmservice.entity.Film;
import com.ibm.academy.cms.filmservice.mapper.FilmMapper;
import com.ibm.academy.cms.filmservice.service.FilmService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/films")
@AllArgsConstructor
public class FilmController {

    private final FilmService filmService;
    private final FilmAssembler filmAssembler;
    private final FilmMapper filmMapper;

    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<CollectionModel<FilmDto>> findAll() {
        List<Film> films = filmService.findAll();
        return new ResponseEntity<>(filmAssembler.toCollectionModel(films), HttpStatus.OK);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public ResponseEntity<FilmDto> findById(@PathVariable ObjectId id) {
        Film film = filmService.findById(id);
        return new ResponseEntity<>(filmAssembler.toModel(film), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<FilmDto> create(@Validated @RequestBody FilmDto filmDto) {
        Film film = filmService.create(filmMapper.toEntity(filmDto));
        return new ResponseEntity<>(filmAssembler.toModel(film), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<FilmDto> update(@PathVariable ObjectId id, @Validated @RequestBody FilmDto filmDto) {
        Film film = filmService.update(id, filmMapper.toEntity(filmDto));
        return new ResponseEntity<>(filmAssembler.toModel(film), HttpStatus.ACCEPTED);
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("permitAll()")
    @PatchMapping("/{filmId}/add-actor/{actorId}")
    public ResponseEntity<FilmDto> addActor(@PathVariable ObjectId filmId, @PathVariable ObjectId actorId) {
        Film film = filmService.addActorToFilm(actorId, filmId);
        return new ResponseEntity<>(filmAssembler.toModel(film), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ObjectId id) {
        filmService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
