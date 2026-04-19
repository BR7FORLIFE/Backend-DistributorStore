package com.tecno_comfenalco.pa.features.routes.deliveries.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.delivery.mapper.MongoDeliveryMapper;
import com.tecno_comfenalco.pa.features.order.mapper.MongoOrderMapper;
import com.tecno_comfenalco.pa.features.routes.deliveries.entity.mongo.DeliveryRoutesDocument;
import com.tecno_comfenalco.pa.features.routes.models.delivery.DeliveryRoutesModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoOrderMapper.class, MongoDeliveryMapper.class })
public interface MongoDeliveryRoutesMapper extends EntityMapper<DeliveryRoutesModel, DeliveryRoutesDocument> {
    @Override
    @Mapping(target = "delivery", ignore = true)
    DeliveryRoutesModel toDto(DeliveryRoutesDocument document);

    @Override
    @Mapping(target = "delivery", ignore = true)
    DeliveryRoutesDocument toEntity(DeliveryRoutesModel model);
}
