package com.tecno_comfenalco.pa.features.category.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.catalog.mapper.MongoCatalogMapper;
import com.tecno_comfenalco.pa.features.category.entity.mongo.CategoryDocument;
import com.tecno_comfenalco.pa.features.category.models.CategoryModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoCatalogMapper.class })
public interface MongoCategoryMapper extends EntityMapper<CategoryModel, CategoryDocument> {
    @Override
    @Mapping(target = "products", ignore = true)
    CategoryModel toDto(CategoryDocument document);

    @Override
    @Mapping(target = "products", ignore = true)
    CategoryDocument toEntity(CategoryModel model);
}
