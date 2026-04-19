package com.tecno_comfenalco.pa.features.catalog.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.catalog.entity.postgres.ProductsCatalogEntity;
import com.tecno_comfenalco.pa.features.catalog.models.ProductCatalogModel;
import com.tecno_comfenalco.pa.features.category.mapper.PostgresCategoryMapper;
import com.tecno_comfenalco.pa.features.product.mapper.PostgresProductMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresCategoryMapper.class, PostgresProductMapper.class })
public interface PostgresProductCatalogMapper extends EntityMapper<ProductCatalogModel, ProductsCatalogEntity> {

}
