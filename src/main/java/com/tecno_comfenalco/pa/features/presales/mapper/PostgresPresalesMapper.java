package com.tecno_comfenalco.pa.features.presales.mapper;

import org.mapstruct.Mapper;

import com.tecno_comfenalco.pa.features.distributor.mapper.PostgresDistributorMapper;
import com.tecno_comfenalco.pa.features.presales.entity.postgres.PresalesEntity;
import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;
import com.tecno_comfenalco.pa.security.mapper.PostgresUserMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresUserMapper.class, PostgresDistributorMapper.class })
public interface PostgresPresalesMapper extends EntityMapper<PresalesModel, PresalesEntity> {

}
