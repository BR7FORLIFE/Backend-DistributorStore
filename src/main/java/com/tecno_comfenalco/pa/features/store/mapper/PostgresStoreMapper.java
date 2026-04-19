package com.tecno_comfenalco.pa.features.store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tecno_comfenalco.pa.features.routes.presales.mapper.PostgresPresalesRoutesMapper;
import com.tecno_comfenalco.pa.features.store.entity.postgres.StoreEntity;
import com.tecno_comfenalco.pa.features.store.models.StoreModel;
import com.tecno_comfenalco.pa.security.mapper.PostgresUserMapper;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

import org.springframework.context.annotation.Profile;

@Profile("postgres")
@Mapper(componentModel = "spring", uses = { PostgresUserMapper.class, PostgresPresalesRoutesMapper.class })
public interface PostgresStoreMapper extends EntityMapper<StoreModel, StoreEntity> {
        @Override
        @Mapping(target = "storesDistributors", ignore = true)
        StoreModel toDto(StoreEntity entity);
}
