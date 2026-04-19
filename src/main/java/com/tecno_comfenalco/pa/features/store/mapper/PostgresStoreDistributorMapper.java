package com.tecno_comfenalco.pa.features.store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.store.entity.postgres.StoresDistributorsEntity;
import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresStoreMapper.class })
public interface PostgresStoreDistributorMapper extends EntityMapper<StoreDistributorModel, StoresDistributorsEntity> {
    @Override
    @Mapping(target = "store", ignore = true)
    StoreDistributorModel toDto(StoresDistributorsEntity entity);
}
