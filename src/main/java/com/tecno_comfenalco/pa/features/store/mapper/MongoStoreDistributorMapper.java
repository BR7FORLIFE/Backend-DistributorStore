package com.tecno_comfenalco.pa.features.store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoresDistributorsDocument;
import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoStoreMapper.class })
public interface MongoStoreDistributorMapper extends EntityMapper<StoreDistributorModel, StoresDistributorsDocument> {
    @Override
    @Mapping(target = "store", ignore = true)
    StoreDistributorModel toDto(StoresDistributorsDocument document);
}
