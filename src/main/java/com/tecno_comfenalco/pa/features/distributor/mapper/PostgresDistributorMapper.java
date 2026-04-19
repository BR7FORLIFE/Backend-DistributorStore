package com.tecno_comfenalco.pa.features.distributor.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.distributor.entity.postgres.DistributorEntity;
import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
import com.tecno_comfenalco.pa.features.store.mapper.PostgresStoreDistributorMapper;
import com.tecno_comfenalco.pa.security.mapper.PostgresUserMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresUserMapper.class, PostgresStoreDistributorMapper.class })
public interface PostgresDistributorMapper extends EntityMapper<DistributorModel, DistributorEntity> {

}
