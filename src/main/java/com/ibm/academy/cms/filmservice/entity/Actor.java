package com.ibm.academy.cms.filmservice.entity;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Node("actor")
public class Actor extends Person {

}
