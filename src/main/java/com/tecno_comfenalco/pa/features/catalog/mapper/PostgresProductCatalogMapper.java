package com.tecno_comfenalco.pa.features.catalog.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.catalog.entity.postgres.ProductsCatalogEntity;
import com.tecno_comfenalco.pa.features.catalog.models.ProductCatalogModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresProductCatalogMapper implements EntityMapper<ProductCatalogModel, ProductsCatalogEntity> {

    @Override
    public ProductCatalogModel toDto(ProductsCatalogEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public ProductsCatalogEntity toEntity(ProductCatalogModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<ProductCatalogModel> toDto(List<ProductsCatalogEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<ProductsCatalogEntity> toEntity(List<ProductCatalogModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<ProductCatalogModel> toDto(Set<ProductsCatalogEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<ProductsCatalogEntity> toEntity(Set<ProductCatalogModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(ProductCatalogModel dto, ProductsCatalogEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
