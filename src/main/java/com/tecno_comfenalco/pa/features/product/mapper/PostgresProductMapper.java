package com.tecno_comfenalco.pa.features.product.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.product.entity.postgres.ProductEntity;
import com.tecno_comfenalco.pa.features.product.models.ProductModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresProductMapper implements EntityMapper<ProductModel, ProductEntity> {

    @Override
    public ProductModel toDto(ProductEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public ProductEntity toEntity(ProductModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<ProductModel> toDto(List<ProductEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<ProductEntity> toEntity(List<ProductModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<ProductModel> toDto(Set<ProductEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<ProductEntity> toEntity(Set<ProductModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(ProductModel dto, ProductEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
