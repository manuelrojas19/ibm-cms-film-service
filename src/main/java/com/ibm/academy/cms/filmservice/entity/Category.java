package com.ibm.academy.cms.filmservice.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Category extends BaseEntity {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @DocumentReference
    private List<Film> films;

}
