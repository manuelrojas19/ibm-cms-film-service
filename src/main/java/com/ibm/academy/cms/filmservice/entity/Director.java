package com.ibm.academy.cms.filmservice.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
<<<<<<< HEAD
=======
import org.springframework.data.mongodb.core.mapping.DocumentReference;
>>>>>>> release/0.3.0

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "directors")
public class Director extends Person {

<<<<<<< HEAD
=======
    @DocumentReference
>>>>>>> release/0.3.0
    private List<Film> directedFilms;

}
