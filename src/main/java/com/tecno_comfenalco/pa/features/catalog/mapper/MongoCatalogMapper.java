package com.tecno_comfenalco.pa.features.catalog.mapper;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Profile;

import com.tecno_comfenalco.pa.features.catalog.entity.mongo.CatalogDocument;
import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.features.distributor.mapper.MongoDistributorMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

@Profile("mongo")
@Mapper(componentModel = "spring", uses = { MongoDistributorMapper.class })
public interface MongoCatalogMapper extends EntityMapper<CatalogModel, CatalogDocument> {

}
