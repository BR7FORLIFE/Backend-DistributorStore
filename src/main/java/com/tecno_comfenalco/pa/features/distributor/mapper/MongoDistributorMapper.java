package com.tecno_comfenalco.pa.features.distributor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.distributor.entity.mongo.DistributorDocument;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring")
public interface MongoDistributorMapper extends EntityMapper<DistributorModel, DistributorDocument> {
    @Override
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "storesDistributors", ignore = true)
    DistributorModel toDto(DistributorDocument document);
}
