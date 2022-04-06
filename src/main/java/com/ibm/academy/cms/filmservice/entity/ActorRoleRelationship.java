package com.ibm.academy.cms.filmservice.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@RelationshipProperties
public class ActorRoleRelationship {

    @RelationshipId
    private Long id;

    private List<String> roles;

    @TargetNode
    private Actor actor;
}
