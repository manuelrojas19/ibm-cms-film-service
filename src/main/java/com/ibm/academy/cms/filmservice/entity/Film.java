package com.ibm.academy.cms.filmservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Node("film")
public class Film extends AuditMetadata {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date date;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Roles> actorsAndRoles = new ArrayList<>();

    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
    private List<Director> directors = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        if (!super.equals(o)) return false;
        Film film = (Film) o;
        return Objects.equals(getTitle(), film.getTitle()) && Objects.equals(getDescription(), film.getDescription()) && Objects.equals(getDate(), film.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTitle(), getDescription(), getDate());
    }
}
