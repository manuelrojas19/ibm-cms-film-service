package com.ibm.academy.cms.filmservice.dto;

import com.ibm.academy.cms.filmservice.entity.Film;
import lombok.Data;

import java.util.List;

@Data
public class ActorDto extends PersonDto {

    private List<Film> films;

}
