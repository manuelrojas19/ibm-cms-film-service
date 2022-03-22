package com.ibm.academy.cms.filmservice.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "actors")
public class Actor extends Person {

    @DocumentReference
    private List<Film> films;

}
