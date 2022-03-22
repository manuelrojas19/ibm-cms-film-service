package com.ibm.academy.cms.filmservice.assembler;

import com.google.common.collect.Streams;
import com.ibm.academy.cms.filmservice.controller.FilmController;
import com.ibm.academy.cms.filmservice.dto.ActorDto;
import com.ibm.academy.cms.filmservice.dto.FilmDto;
import com.ibm.academy.cms.filmservice.entity.Actor;
import com.ibm.academy.cms.filmservice.mapper.PersonMapper;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@AllArgsConstructor
public class ActorAssembler implements RepresentationModelAssembler<Actor, ActorDto> {

    private final PersonMapper personMapper;

    @Override
    public ActorDto toModel(Actor entity) {
        ActorDto dto = personMapper.toDto(entity);
        // TODO: add links
        return dto;
    }

    @Override
    public CollectionModel<ActorDto> toCollectionModel(Iterable<? extends Actor> entities) {
        CollectionModel<ActorDto> dtos = CollectionModel.of(Streams.stream(entities)
                .map(this::toModel).collect(Collectors.toList()));
        // TODO: add links
        return dtos;
    }
}
