package com.ibm.academy.cms.filmservice.mapper;

import com.ibm.academy.cms.filmservice.dto.CategoryDto;
import com.ibm.academy.cms.filmservice.entity.Category;
import org.mapstruct.Mapper;


@Mapper(uses = {DataMapper.class})
public interface CategoryMapper {
    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDto);
}
