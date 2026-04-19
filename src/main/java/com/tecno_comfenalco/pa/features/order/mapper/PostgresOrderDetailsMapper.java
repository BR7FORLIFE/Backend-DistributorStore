package com.tecno_comfenalco.pa.features.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.order.entity.postgres.OrderDetailEntity;
import com.tecno_comfenalco.pa.features.order.models.OrderDetailsModel;
import com.tecno_comfenalco.pa.features.product.mapper.PostgresProductMapper;
import com.tecno_comfenalco.pa.features.routes.presales.mapper.PostgresPresalesRoutesMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresProductMapper.class, PostgresPresalesRoutesMapper.class })
public interface PostgresOrderDetailsMapper extends EntityMapper<OrderDetailsModel, OrderDetailEntity> {
    @Override
    @Mapping(target = "order", ignore = true)
    OrderDetailsModel toDto(OrderDetailEntity entity);

    @Override
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "id.orderId", source = "order.id")
    @Mapping(target = "id.productId", source = "product.id")
    OrderDetailEntity toEntity(OrderDetailsModel dto);
}
