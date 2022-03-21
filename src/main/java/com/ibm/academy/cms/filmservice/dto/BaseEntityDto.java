package com.ibm.academy.cms.filmservice.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Null;
import java.util.Date;

@Data
public class BaseEntityDto extends RepresentationModel<BaseEntityDto> {

    @Null
    private String id;

    @Null
    private Long version;

    @Null
    private Date createdAt;

    @Null
    private Date lastModifiedAt;

    @Null
    private String createdBy;

    @Null
    private String lastModifiedBy;

}
