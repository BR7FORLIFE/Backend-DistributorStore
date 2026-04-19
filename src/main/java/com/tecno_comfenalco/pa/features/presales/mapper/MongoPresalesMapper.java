package com.tecno_comfenalco.pa.features.presales.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.presales.entity.mongo.PresalesDocument;
import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;
import com.tecno_comfenalco.pa.security.mapper.MongoUserMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoUserMapper.class })
public interface MongoPresalesMapper extends EntityMapper<PresalesModel, PresalesDocument> {
    @Override
    @Mapping(target = "distributor", ignore = true)
    PresalesModel toDto(PresalesDocument document);
}
