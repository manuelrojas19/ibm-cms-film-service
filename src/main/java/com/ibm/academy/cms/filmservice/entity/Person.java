package com.ibm.academy.cms.filmservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Person extends BaseEntity {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date bornDate;

    @NotBlank
    private String bornPlace;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && getDescription().equals(person.getDescription()) && getBornDate().equals(person.getBornDate()) && getBornPlace().equals(person.getBornPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getDescription(), getBornDate(), getBornPlace());
    }
}
