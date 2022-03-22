package com.ibm.academy.cms.filmservice.controller;

import com.ibm.academy.cms.filmservice.assembler.ActorAssembler;
import com.ibm.academy.cms.filmservice.dto.ActorDto;
import com.ibm.academy.cms.filmservice.entity.Actor;
import com.ibm.academy.cms.filmservice.mapper.PersonMapper;
import com.ibm.academy.cms.filmservice.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/actors")
@AllArgsConstructor
public class ActorController {

    private final ActorService actorService;
    private final ActorAssembler actorAssembler;
    private final PersonMapper personMapper;

    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<CollectionModel<ActorDto>> findAll() {
        List<Actor> actors = actorService.findAll()
                .stream().map(person -> (Actor) person)
                .collect(Collectors.toList());
        return new ResponseEntity<>(actorAssembler.toCollectionModel(actors), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ActorDto> create(@Validated @RequestBody ActorDto actorDto) {
        Actor actor = (Actor) actorService.create(personMapper.toEntity(actorDto));
        return new ResponseEntity<>(actorAssembler.toModel(actor), HttpStatus.CREATED);
    }

}
