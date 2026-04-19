package com.tecno_comfenalco.pa.features.catalog.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.ProductsCatalogDocument;
import com.tecno_comfenalco.pa.features.catalog.models.ProductCatalogModel;
import com.tecno_comfenalco.pa.features.category.mapper.MongoCategoryMapper;
import com.tecno_comfenalco.pa.features.product.mapper.MongoProductMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;
import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoCategoryMapper.class, MongoProductMapper.class })
public interface MongoProductCatalogMapper extends EntityMapper<ProductCatalogModel, ProductsCatalogDocument> {

}
