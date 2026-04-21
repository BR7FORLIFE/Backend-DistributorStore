package com.tecno_comfenalco.pa.infrastructure.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.domain.product.model.ProductModel;
import com.tecno_comfenalco.pa.infrastructure.product.entity.ProductDocument;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductModel, ProductDocument> {
    @Override
    @Mapping(source = "id", target = "id")
    @Mapping(source = "distributorId", target = "distributorId")
    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "unit", target = "unit")
    ProductDocument toEntity(ProductModel dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "distributorId", target = "distributorId")
    @Mapping(source = "sku", target = "sku")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "unit", target = "unit")
    ProductModel toDto(ProductDocument entity);
}
