package com.tecno_comfenalco.pa.features.store.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.store.entity.postgres.StoreEntity;
import com.tecno_comfenalco.pa.features.store.models.StoreModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresStoreMapper implements EntityMapper<StoreModel, StoreEntity> {

    @Override
    public StoreModel toDto(StoreEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public StoreEntity toEntity(StoreModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<StoreModel> toDto(List<StoreEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<StoreEntity> toEntity(List<StoreModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<StoreModel> toDto(Set<StoreEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<StoreEntity> toEntity(Set<StoreModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(StoreModel dto, StoreEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }

}
