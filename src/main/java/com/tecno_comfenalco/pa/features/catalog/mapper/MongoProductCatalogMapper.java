package com.tecno_comfenalco.pa.features.catalog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.ProductsCatalogDocument;
import com.tecno_comfenalco.pa.features.catalog.models.ProductCatalogModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;
import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring")
public interface MongoProductCatalogMapper extends EntityMapper<ProductCatalogModel, ProductsCatalogDocument> {

    @Override
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "category", ignore = true)
    ProductCatalogModel toDto(ProductsCatalogDocument document);

    @Override
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "category", ignore = true)
    ProductsCatalogDocument toEntity(ProductCatalogModel model);
}
