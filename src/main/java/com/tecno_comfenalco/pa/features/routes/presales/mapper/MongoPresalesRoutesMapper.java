package com.tecno_comfenalco.pa.features.routes.presales.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.presales.mapper.MongoPresalesMapper;
import com.tecno_comfenalco.pa.features.routes.models.presales.PresalesRoutesModel;
import com.tecno_comfenalco.pa.features.routes.presales.entity.mongo.PresalesRoutesDocument;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoPresalesMapper.class })
public interface MongoPresalesRoutesMapper extends EntityMapper<PresalesRoutesModel, PresalesRoutesDocument> {
    @Override
    @Mapping(target = "stores", ignore = true) 
    PresalesRoutesModel toDto(PresalesRoutesDocument document);
}
