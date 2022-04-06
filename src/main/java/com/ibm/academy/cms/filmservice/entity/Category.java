package com.ibm.academy.cms.filmservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Node;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Node("category")
public class Category extends AuditMetadata {


    private String name;

    @NotBlank
    private String description;

}
