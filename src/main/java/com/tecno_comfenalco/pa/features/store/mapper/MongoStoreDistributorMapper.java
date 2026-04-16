package com.tecno_comfenalco.pa.features.store.mapper;

import java.util.List;
import java.util.Set;

import com.tecno_comfenalco.pa.features.store.entity.mongo.StoresDistributorsDocument;
import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;
import com.tecno_comfenalco.pa.shared.mapper.EntityMapper;

public class MongoStoreDistributorMapper implements EntityMapper<StoreDistributorModel, StoresDistributorsDocument> {

    @Override
    public StoreDistributorModel toDto(StoresDistributorsDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public StoresDistributorsDocument toEntity(StoreDistributorModel dto) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public List<StoreDistributorModel> toDto(List<StoresDistributorsDocument> entityList) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public List<StoresDistributorsDocument> toEntity(List<StoreDistributorModel> dtoList) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public Set<StoreDistributorModel> toDto(Set<StoresDistributorsDocument> entitySet) {
        throw new UnsupportedOperationException("Unimplemented method 'toDto'");
    }

    @Override
    public Set<StoresDistributorsDocument> toEntity(Set<StoreDistributorModel> dtoSet) {
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

    @Override
    public void updateEntityFromDto(StoreDistributorModel dto, StoresDistributorsDocument entity) {
        throw new UnsupportedOperationException("Unimplemented method 'updateEntityFromDto'");
    }
    
}
