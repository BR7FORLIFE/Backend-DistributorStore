package com.tecno_comfenalco.pa.features.store.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.store.entity.postgres.StoresDistributorsEntity;
import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class PostgresStoreDistributorMapper implements EntityMapper<StoreDistributorModel, StoresDistributorsEntity> {

    @Override
    public StoreDistributorModel toDto(StoresDistributorsEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public StoresDistributorsEntity toEntity(StoreDistributorModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<StoreDistributorModel> toDto(List<StoresDistributorsEntity> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<StoresDistributorsEntity> toEntity(List<StoreDistributorModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<StoreDistributorModel> toDto(Set<StoresDistributorsEntity> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<StoresDistributorsEntity> toEntity(Set<StoreDistributorModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(StoreDistributorModel dto, StoresDistributorsEntity entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }

}
