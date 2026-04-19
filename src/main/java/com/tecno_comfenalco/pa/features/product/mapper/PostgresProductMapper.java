package com.tecno_comfenalco.pa.features.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.distributor.mapper.PostgresDistributorMapper;
import com.tecno_comfenalco.pa.features.product.entity.postgres.ProductEntity;
import com.tecno_comfenalco.pa.features.product.models.ProductModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresDistributorMapper.class })
public interface PostgresProductMapper extends EntityMapper<ProductModel, ProductEntity> {
        @Override
        @Mapping(target = "orderDetails", ignore = true)
        ProductModel toDto(ProductEntity entity);

        @Override
        @Mapping(target = "orderDetails", ignore = true)
        ProductEntity toEntity(ProductModel dto);
}
