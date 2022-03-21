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

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/v1/films")
@AllArgsConstructor
public class FilmController {

    private final FilmService filmService;
    private final FilmAssembler filmAssembler;
    private final FilmMapper filmMapper;

    @RolesAllowed("SUBSCRIBER")
    @GetMapping
    public ResponseEntity<CollectionModel<FilmDto>> findAll() {
        List<Film> films = filmService.findAll();
        return new ResponseEntity<>(filmAssembler.toCollectionModel(films), HttpStatus.OK);
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<FilmDto> findById(@PathVariable ObjectId id) {
        Film film = filmService.findById(id);
        return new ResponseEntity<>(filmAssembler.toModel(film), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FilmDto> create(@Validated @RequestBody FilmDto filmDto) {
        Film film = filmService.create(filmMapper.toEntity(filmDto));
        return new ResponseEntity<>(filmAssembler.toModel(film), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDto> update(@PathVariable ObjectId id, @Validated @RequestBody FilmDto filmDto) {
        Film film = filmService.update(id, filmMapper.toEntity(filmDto));
        return new ResponseEntity<>(filmAssembler.toModel(film), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ObjectId id) {
        filmService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
