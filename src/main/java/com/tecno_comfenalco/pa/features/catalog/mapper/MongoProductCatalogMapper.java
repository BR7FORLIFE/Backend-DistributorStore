package com.tecno_comfenalco.pa.features.catalog.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.ProductsCatalogDocument;
import com.tecno_comfenalco.pa.features.catalog.models.ProductCatalogModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoProductCatalogMapper implements EntityMapper<ProductCatalogModel, ProductsCatalogDocument> {

    @Override
    public ProductCatalogModel toDto(ProductsCatalogDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public ProductsCatalogDocument toEntity(ProductCatalogModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<ProductCatalogModel> toDto(List<ProductsCatalogDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<ProductsCatalogDocument> toEntity(List<ProductCatalogModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<ProductCatalogModel> toDto(Set<ProductsCatalogDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<ProductsCatalogDocument> toEntity(Set<ProductCatalogModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(ProductCatalogModel dto, ProductsCatalogDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
