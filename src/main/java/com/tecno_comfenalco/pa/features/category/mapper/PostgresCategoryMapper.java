package com.tecno_comfenalco.pa.features.category.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.catalog.mapper.PostgresCatalogMapper;
import com.tecno_comfenalco.pa.features.category.entity.postgres.CategoryEntity;
import com.tecno_comfenalco.pa.features.category.models.CategoryModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresCatalogMapper.class })
public interface PostgresCategoryMapper extends EntityMapper<CategoryModel, CategoryEntity> {
    @Override
    @Mapping(target = "products", ignore = true)
    CategoryModel toDto(CategoryEntity entity);

    @Override
    @Mapping(target = "products", ignore = true)
    CategoryEntity toEntity(CategoryModel dto);
}
