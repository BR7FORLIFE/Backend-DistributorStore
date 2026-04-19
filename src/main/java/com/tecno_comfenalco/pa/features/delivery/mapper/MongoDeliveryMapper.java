package com.tecno_comfenalco.pa.features.delivery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.delivery.entity.mongo.DeliveryDocument;
import com.tecno_comfenalco.pa.features.delivery.model.DeliveryModel;
import com.tecno_comfenalco.pa.features.distributor.mapper.MongoDistributorMapper;
import com.tecno_comfenalco.pa.security.mapper.MongoUserMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoUserMapper.class, MongoDistributorMapper.class })
public interface MongoDeliveryMapper extends EntityMapper<DeliveryModel, DeliveryDocument> {
        @Override
        @Mapping(target = "routes", ignore = true)
        DeliveryModel toDto(DeliveryDocument document);

        @Override
        @Mapping(target = "routes", ignore = true)
        DeliveryDocument toEntity(DeliveryModel model);
}
