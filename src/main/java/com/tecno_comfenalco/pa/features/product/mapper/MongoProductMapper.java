package com.tecno_comfenalco.pa.features.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.distributor.mapper.MongoDistributorMapper;
import com.tecno_comfenalco.pa.features.product.entity.mongo.ProductDocument;
import com.tecno_comfenalco.pa.features.product.models.ProductModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoDistributorMapper.class })
public interface MongoProductMapper extends EntityMapper<ProductModel, ProductDocument> {
        @Override
        @Mapping(target = "orderDetails", ignore = true)
        ProductModel toDto(ProductDocument document);

        @Override
        @Mapping(target = "orderDetails", ignore = true)
        ProductDocument toEntity(ProductModel model);
}
