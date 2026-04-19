package com.tecno_comfenalco.pa.features.order.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.order.entity.mongo.OrderDetailDocument;
import com.tecno_comfenalco.pa.features.order.models.OrderDetailsModel;
import com.tecno_comfenalco.pa.features.product.mapper.MongoProductMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoProductMapper.class })
public interface MongoOrderDetailsMapper extends EntityMapper<OrderDetailsModel, OrderDetailDocument> {
    @Override
    @Mapping(target = "id.orderId", source = "order.id")
    @Mapping(target = "id.productId", source = "product.id")
    @Mapping(target = "order", ignore = true)
    OrderDetailsModel toDto(OrderDetailDocument document);

    @Override
    @Mapping(target = "id", source = "model.id.orderId")
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "product", ignore = true)
    OrderDetailDocument toEntity(OrderDetailsModel model);
}
