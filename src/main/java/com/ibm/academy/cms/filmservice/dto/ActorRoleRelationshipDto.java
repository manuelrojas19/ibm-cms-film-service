package com.ibm.academy.cms.filmservice.dto;

import com.ibm.academy.cms.filmservice.entity.Actor;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import javax.validation.constraints.Null;
import java.util.List;

@Data
public class ActorRoleRelationshipDto {

    @Null
    private Long id;

    @Null
    private List<String> roles;

    @Null
    private Actor actor;
}
