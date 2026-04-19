package com.tecno_comfenalco.pa.features.store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoreDocument;
import com.tecno_comfenalco.pa.features.store.models.StoreModel;
import com.tecno_comfenalco.pa.security.mapper.MongoUserMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoUserMapper.class })
public interface MongoStoreMapper extends EntityMapper<StoreModel, StoreDocument> {
        @Override
        @Mapping(target = "presalesRoute", ignore = true)
        @Mapping(target = "storesDistributors", ignore = true)
        StoreModel toDto(StoreDocument document);

        @Override
        @Mapping(target = "presalesRoute", ignore = true)
        @Mapping(target = "storesDistributors", ignore = true)
        StoreDocument toEntity(StoreModel model);
}
