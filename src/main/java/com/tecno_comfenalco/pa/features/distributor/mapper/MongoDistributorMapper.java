package com.tecno_comfenalco.pa.features.distributor.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.features.store.mapper.MongoStoreDistributorMapper;
import com.tecno_comfenalco.pa.security.mapper.MongoUserMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoUserMapper.class, MongoStoreDistributorMapper.class })
public interface MongoDistributorMapper extends EntityMapper<DistributorModel, DistributorDocument> {

}
