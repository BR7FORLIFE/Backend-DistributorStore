package com.tecno_comfenalco.pa.features.catalog.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.catalog.entity.postgres.CatalogEntity;
import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;
import com.tecno_comfenalco.pa.features.distributor.mapper.PostgresDistributorMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;
import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresDistributorMapper.class })
public interface PostgresCatalogMapper extends EntityMapper<CatalogModel, CatalogEntity> {

}
