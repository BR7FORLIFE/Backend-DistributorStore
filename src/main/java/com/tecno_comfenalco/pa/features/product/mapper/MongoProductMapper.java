package com.tecno_comfenalco.pa.features.product.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.product.entity.mongo.ProductDocument;
import com.tecno_comfenalco.pa.features.product.models.ProductModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoProductMapper implements EntityMapper<ProductModel, ProductDocument>{

    @Override
    public ProductModel toDto(ProductDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public ProductDocument toEntity(ProductModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<ProductModel> toDto(List<ProductDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<ProductDocument> toEntity(List<ProductModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<ProductModel> toDto(Set<ProductDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<ProductDocument> toEntity(Set<ProductModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(ProductModel dto, ProductDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
