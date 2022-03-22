package com.ibm.academy.cms.filmservice.dto;

import com.ibm.academy.cms.filmservice.entity.Film;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class CategoryDto extends BaseEntityDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private List<Film> films;

}
