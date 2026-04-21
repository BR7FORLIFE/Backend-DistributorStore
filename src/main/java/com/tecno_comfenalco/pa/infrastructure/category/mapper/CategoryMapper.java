package com.tecno_comfenalco.pa.infrastructure.category.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.domain.category.models.CategoryModel;
import com.tecno_comfenalco.pa.infrastructure.category.entity.CategoryEmbeddedEntity;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryModel, CategoryEmbeddedEntity> {

}
